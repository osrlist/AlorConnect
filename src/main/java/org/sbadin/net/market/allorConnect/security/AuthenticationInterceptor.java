package org.sbadin.net.market.allorConnect.security;

import okhttp3.*;
import okio.Buffer;
import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.impl.AlorApiRestNonSecurityClientImpl;

import java.io.IOException;
import java.util.Objects;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final String secret;

    private final AlorApiRestNonSecurityClientImpl authorToken;

    public AuthenticationInterceptor(String secret ) {
        this.secret = secret;
        this.authorToken = new AlorApiRestNonSecurityClientImpl();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isApiKeyRequired = original.header(AlorApiConfig.ENDPOINT_SECURITY_APIKEY) != null;
        newRequestBuilder.removeHeader(AlorApiConfig.ENDPOINT_SECURITY_APIKEY);

        // Endpoint requires sending a valid API-KEY
        if (isApiKeyRequired ) {
            newRequestBuilder.addHeader(AlorApiConfig.ENDPOINT_SECURITY_APIKEY, AlorApiConfig.PREFIX_SECURITY + authorToken.getCacheAccessToken(secret));
        }

        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    @SuppressWarnings("unused")
    private static String bodyToString(RequestBody request) {
        try (final Buffer buffer = new Buffer()) {
            final RequestBody copy = request;
            if (copy != null) {
                copy.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
        return  Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secret);
    }
}