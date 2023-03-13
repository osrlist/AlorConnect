package org.sbadin.net.market.allorConnect.impl;

import org.sbadin.net.market.allorConnect.AlorApiRestClient;
import org.sbadin.net.market.allorConnect.domain.*;
import org.sbadin.net.market.allorConnect.domain.general.History;
import org.sbadin.net.market.allorConnect.domain.general.Instrument;
import org.sbadin.net.market.allorConnect.domain.general.User;
import retrofit2.http.Body;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class AlorApiRestClientImpl implements AlorApiRestClient {

    private final AlorApiService alorApiService;

    public AlorApiRestClientImpl(String secret) {
        alorApiService = AlorApiServiceGenerator.createService(AlorApiService.class, secret);
    }

    @Override
    public History getHistory(String symbol, Exchange exchange, TimeFrame ft, Long startTime, Long endTime) {
        Boolean untraded = false;
        String format = "Simple";
        return AlorApiServiceGenerator.executeSync(alorApiService.historyOrder(symbol, exchange.name(), ft, startTime, endTime, untraded, format));
    }

    @Override
    public OrderActions limitOrder(String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange) {
        String guid = java.util.UUID.randomUUID().toString();
        String portfolioUid = portfolio +";"+ guid;

        Instrument instrument = new Instrument();
        instrument.setExchange( exchange );
        instrument.setSymbol(symbol);

        User user = new User();
        user.setPortfolio( portfolio );

        OrderActionsRequest order = new OrderActionsRequest();
        order.setInstrument(instrument);
        order.setUser(user);
        order.setSide( side );
        order.setType("limit");
        order.setQuantity( quantity );
        order.setPrice( price );

        return AlorApiServiceGenerator.executeSync(alorApiService.limitOrder(portfolioUid, order));
    }


}
