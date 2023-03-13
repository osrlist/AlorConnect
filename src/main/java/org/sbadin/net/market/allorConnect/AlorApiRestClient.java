package org.sbadin.net.market.allorConnect;

import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.OrderActions;
import org.sbadin.net.market.allorConnect.domain.Side;
import org.sbadin.net.market.allorConnect.domain.TimeFrame;
import org.sbadin.net.market.allorConnect.domain.general.History;

import java.math.BigDecimal;
import java.util.List;


public interface AlorApiRestClient {

  History getHistory(String symbol, Exchange exchange, TimeFrame ft, Long startTime, Long endTime);

  OrderActions limitOrder(String portfolio, Side side, Integer quantity, BigDecimal price, String symbol, Exchange exchange);

}
