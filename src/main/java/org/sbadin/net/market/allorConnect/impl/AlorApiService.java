package org.sbadin.net.market.allorConnect.impl;

import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.domain.*;
import org.sbadin.net.market.allorConnect.domain.general.History;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AlorApiService {


    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @GET("/md/v2/history")
    Call<History> historyOrder(@Query("symbol") String symbol, @Query("exchange") String exchange, @Query("tf") TimeFrame tf,
                               @Query("from") Long from, @Query("to") Long to, @Query("untraded") Boolean untraded,
                               @Query("format") String format);


    @POST("/refresh")
    Call<Token> getAccessToken(@Query("token") String token);

    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @POST("/commandapi/warptrans/TRADE/v2/client/orders/actions/limit")
    Call<OrderAction> limitOrder(@Header("X-ALOR-REQID") String portfolioUid, @Body OrderActionsRequest order);

    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @PUT("/commandapi/warptrans/TRADE/v2/client/orders/actions/limit/{orderId}")
    Call<OrderAction> updateLimitOrder(@Header("X-ALOR-REQID") String portfolioUid,
                                       @Path("orderId") String orderId,
                                       @Body OrderUpdateRequest order);
    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @DELETE("/commandapi/warptrans/TRADE/v2/client/orders/{orderId}")
    Call<OrderAction> deleteLimitOrder(@Path("orderId") String orderId,
                                       @Query("portfolio") String portfolio,
                                       @Query("exchange") Exchange exchange,
                                       @Query("stop") Boolean stop,
                                       @Query("jsonResponse") Boolean jsonResponse,
                                       @Query("format") String format
                                       );
    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @POST("/commandapi/warptrans/TRADE/v2/client/orders/actions/market")
    Call<OrderAction> marketOrder(@Header("X-ALOR-REQID") String portfolioUid,
                                  @Body MarketOrderRequest order
    );

    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @POST("/commandapi/warptrans/TRADE/v2/client/orders/actions/stop")
    Call<OrderAction> marketStopLoss(@Header("X-ALOR-REQID") String portfolioUid,
                                     @Body MarketStoplossRequest order
    );


    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @GET("/md/v2/clients/{exchange}/{portfolio}/orders")
    Call<List<LimitOrder>> orders(@Path("portfolio") String portfolio,
                             @Path("exchange") Exchange exchange,
                             @Query("format") String format
    );

    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @GET("/md/v2/clients/{exchange}/{portfolio}/stoporders")
    Call<List<StopLimitEvent>> stopOrders(@Path("portfolio") String portfolio,
                                          @Path("exchange") Exchange exchange,
                                          @Query("format") String format
    );



}
