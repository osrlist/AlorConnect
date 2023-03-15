package org.sbadin.net.market.allorConnect;

import org.sbadin.net.market.allorConnect.domain.*;
import org.sbadin.net.market.allorConnect.domain.general.History;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.math.BigDecimal;


public interface AlorApiRestClient {

  History getHistory(String symbol, Exchange exchange, TimeFrame ft, Long startTime, Long endTime);

  OrderAction limitOrder(String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange);
  OrderAction updateLimitOrder( String orderId, String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange);
  DeleteOrder deleteLimitOrder( String orderId, String portfolio, Exchange exchange, Boolean stop,Boolean jsonResponse);
}
