package org.sbadin.net.market.allorConnect.impl;

import org.sbadin.net.market.allorConnect.AlorApiRestNonSecurityClient;
import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.domain.Token;

import java.util.Date;

public class AlorApiRestNonSecurityClientImpl implements AlorApiRestNonSecurityClient {

    private Token validToken = null;
    private Long ttlToken = null;
    private final AlorApiService alorApiService;

    public AlorApiRestNonSecurityClientImpl() {
        alorApiService = AlorApiServiceGenerator.createService(AlorApiService.class,  null, true );
    }

    @Override
    public Token getAccessToken(String token) {
        return AlorApiServiceGenerator.executeSync(alorApiService.getAccessToken(token));
    }

    public String getCacheAccessToken(String token) {
       Long currentTime = new Date().getTime();
       if (validToken == null)  {
           validToken = getAccessToken(token);
           Date now  = new Date();
           ttlToken =  now.getTime();
       } else if ( (currentTime - ttlToken) > 1000 * AlorApiConfig.getJwtTokenTTL() ) {
           validToken = getAccessToken(token);
           Date now  = new Date();
           ttlToken =  now.getTime();
       }
       return validToken.getAccessToken();
    }



}
