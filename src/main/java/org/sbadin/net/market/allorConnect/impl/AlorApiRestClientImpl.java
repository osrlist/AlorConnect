package org.sbadin.net.market.allorConnect.impl;

import org.sbadin.net.market.allorConnect.AlorApiRestClient;
import org.sbadin.net.market.allorConnect.domain.TimeFrame;
import org.sbadin.net.market.allorConnect.domain.general.History;

import java.util.List;

public class AlorApiRestClientImpl implements AlorApiRestClient {

    private final AlorApiService alorApiService;

    public AlorApiRestClientImpl(String secret) {
        alorApiService = AlorApiServiceGenerator.createService(AlorApiService.class, secret);
    }

    @Override
    public History getHistory(String symbol, String exchange, TimeFrame ft, Long startTime, Long endTime) {
        Boolean untraded = false;
        String format = "Simple";
        return AlorApiServiceGenerator.executeSync(alorApiService.historyOrder(symbol, exchange, ft, startTime, endTime, untraded, format));
    }
}
