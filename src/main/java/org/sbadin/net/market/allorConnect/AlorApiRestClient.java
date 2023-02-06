package org.sbadin.net.market.allorConnect;

import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.TimeFrame;
import org.sbadin.net.market.allorConnect.domain.general.History;

import java.util.List;


public interface AlorApiRestClient {

  History getHistory(String symbol, Exchange exchange, TimeFrame ft, Long startTime, Long endTime);



}
