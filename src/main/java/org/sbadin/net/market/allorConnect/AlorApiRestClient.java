package org.sbadin.net.market.allorConnect;

import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.domain.*;
import org.sbadin.net.market.allorConnect.domain.general.History;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.util.List;


public interface AlorApiRestClient {

  History getHistory(String symbol, Exchange exchange, TimeFrame ft, Long startTime, Long endTime);

  OrderAction limitOrder(String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange);
  OrderAction updateLimitOrder( String orderId, String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange);
  OrderAction deleteLimitOrder( String orderId, String portfolio, Exchange exchange, Boolean stop);
  OrderAction marketOrder(String portfolio, Side side, Integer quantity,  String symbol, Exchange exchange);
  OrderAction marketStopLoss(String portfolio, Side side, Integer quantity,  String symbol, Exchange exchange, BigDecimal triggerPrice, Long orderEndUnixTime, Condition condition);

  List<LimitOrder> orders( String portfolio, Exchange exchange );

  List<StopLimitEvent> stopOrders( String portfolio, Exchange exchange );


}
