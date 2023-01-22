package org.sbadin.net.market.allorConnect.impl;

import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.domain.TimeFrame;
import org.sbadin.net.market.allorConnect.domain.Token;
import org.sbadin.net.market.allorConnect.domain.general.History;
import retrofit2.Call;
import retrofit2.http.*;

public interface AlorApiService {


    @Headers(AlorApiConfig.ENDPOINT_SECURITY_TYPE_APIKEY)
    @GET("/md/v2/history")
    Call<History> historyOrder(@Query("symbol") String symbol, @Query("exchange") String exchange, @Query("tf") TimeFrame tf,
                               @Query("from") Long from, @Query("to") Long to, @Query("untraded") Boolean untraded,
                               @Query("format") String format);


    @POST("/refresh")
    Call<Token> getAccessToken(@Query("token") String token);
}
