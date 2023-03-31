package org.sbadin.net.market.allorConnect.impl;

import org.sbadin.net.market.allorConnect.AlorApiRestClient;
import org.sbadin.net.market.allorConnect.domain.*;
import org.sbadin.net.market.allorConnect.domain.general.History;
import org.sbadin.net.market.allorConnect.domain.general.Instrument;
import org.sbadin.net.market.allorConnect.domain.general.User;

import java.math.BigDecimal;

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
    public OrderAction limitOrder(String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange) {
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

    @Override
    public OrderAction updateLimitOrder(String orderId, String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange) {
        String guid = java.util.UUID.randomUUID().toString();
        String portfolioUid = portfolio +";"+ guid;

        Instrument instrument = new Instrument();
        instrument.setExchange( exchange );
        instrument.setSymbol(symbol);

        User user = new User();
        user.setPortfolio( portfolio );

        OrderUpdateRequest order = new OrderUpdateRequest();
        order.setInstrument(instrument);
        order.setUser(user);
        order.setSide( side );
        order.setType("limit");
        order.setQuantity( quantity );
        order.setPrice( price );
        order.setId( orderId );

        return AlorApiServiceGenerator.executeSync(alorApiService.updateLimitOrder(portfolioUid, orderId, order));
    }

    @Override
    public OrderAction deleteLimitOrder(String orderId, String portfolio, Exchange exchange, Boolean stop) {
        String format = "Simple";
        Boolean jsonResponse = true;
        return AlorApiServiceGenerator.executeSync(alorApiService.deleteLimitOrder(orderId, portfolio, exchange, stop, jsonResponse, format));
    }

    @Override
    public OrderAction marketOrder(String portfolio, Side side, Integer quantity, String symbol, Exchange exchange) {
        String guid = java.util.UUID.randomUUID().toString();
        String portfolioUid = portfolio +";"+ guid;

        Instrument instrument = new Instrument();
        instrument.setExchange( exchange );
        instrument.setSymbol(symbol);

        User user = new User();
        user.setPortfolio( portfolio );

        MarketOrderRequest order = new MarketOrderRequest();
        order.setInstrument(instrument);
        order.setUser(user);
        order.setSide( side );
        order.setType("market");
        order.setQuantity( quantity );

        return AlorApiServiceGenerator.executeSync(alorApiService.marketOrder(portfolioUid, order));
    }

    @Override
    public OrderAction marketStopLoss(String portfolio, Side side, Integer quantity, String symbol, Exchange exchange, BigDecimal triggerPrice, Long orderEndUnixTime, Condition condition) {
        String guid = java.util.UUID.randomUUID().toString();
        String portfolioUid = portfolio +";"+ guid;

        Instrument instrument = new Instrument();
        instrument.setExchange( exchange );
        instrument.setSymbol(symbol);

        User user = new User();
        user.setPortfolio( portfolio );

        MarketStoplossRequest order = new MarketStoplossRequest();
        order.setInstrument(instrument);
        order.setUser(user);
        order.setSide( side );
        order.setTriggerPrice( triggerPrice );
        order.setQuantity( quantity );
        order.setOrderEndUnixTime(orderEndUnixTime);
        order.setCondition(condition);
        return AlorApiServiceGenerator.executeSync(alorApiService.marketStopLoss( portfolioUid, order));

    }


}
