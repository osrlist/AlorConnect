package org.sbadin.net.market.allorConnect.impl;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.sbadin.net.market.allorConnect.AlorApiError;
import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.security.AuthenticationInterceptor;
import org.sbadin.net.market.allorConnect.exception.AlorApiException;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

public class AlorApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, AlorApiError> errorBodyConverter =
            (Converter<ResponseBody, AlorApiError>)converterFactory.responseBodyConverter(
                    AlorApiError.class, new Annotation[0], null);

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass,  null);
    }

    /**
         *
     * @param serviceClass the type of service.
     * @param secret alor secret.
     *
     * @return a new implementation of the API endpoints for the Alor API service.
     */
    public static <S> S createService(Class<S> serviceClass, String secret, boolean isAuthor ) {

        String baseUrl = isAuthor? AlorApiConfig.getAuthorBaseUrl(): AlorApiConfig.getApiBaseUrl();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory);

        if ( StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // adaptedClient will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(secret);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                AlorApiError apiError = getAlorApiError(response);
                throw new AlorApiException(apiError);
            }
        } catch (IOException e) {
            throw new AlorApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static AlorApiError getAlorApiError(Response<?> response) throws IOException, AlorApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

    public static <S> S createService(Class<S> serviceClass, String secret ) {
        return createService(serviceClass, secret, false);
    }
    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
