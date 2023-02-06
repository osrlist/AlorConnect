package org.sbadin.net.market.allorConnect.impl;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.sbadin.net.market.allorConnect.AlorApiClientFactory;
import org.sbadin.net.market.allorConnect.AlorApiRestClient;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.domain.ContractEvent;
import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.TimeFrame;
import org.sbadin.net.market.allorConnect.domain.Token;
import org.sbadin.net.market.allorConnect.domain.general.Candle;
import org.sbadin.net.market.allorConnect.domain.general.History;

import java.util.List;

public class AlorApiRestNonSecurityClientImplTest  {
    @Ignore
    @Test
    public void testGetAccessToken() {
        AlorApiRestNonSecurityClientImpl alorApiRestNonSecurityClient = new AlorApiRestNonSecurityClientImpl();
        Token token = alorApiRestNonSecurityClient.getAccessToken("ffff-fff-fff-fff");
        System.out.println( token.getAccessToken() );
    }

    @Ignore
    @Test
    public void testHistory() {
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance ( "fff-ff-f-f-f-f--fff");
        AlorApiRestClient client = factory.newRestClient();

        Long endTime = System.currentTimeMillis();
        endTime = endTime / 1000;

        TimeFrame tf = TimeFrame.D;
        int countCandle = 5;

        History candle = client.getHistory("NGG3", Exchange.MOEX, tf, endTime, endTime);
        endTime = candle.getPrev();
        candle = client.getHistory("NGG3", Exchange.MOEX, tf, endTime - countCandle * tf.getInputSec(), endTime);

        System.out.println( candle.getHistories().size());

        List<Candle> list = candle.getHistories();
        while (list.size() < countCandle) {
            System.out.println( "не все получено");
            endTime = candle.getPrev();
            long mooCandle =  countCandle - list.size();
            candle = client.getHistory("NGG3", Exchange.MOEX, tf, endTime - mooCandle * tf.getInputSec(), endTime);
            System.out.println( candle.getHistories().size());
            System.out.println( candle);
            List<Candle> list2 = candle.getHistories();
            list2.addAll( list);
            list = list2;
        }

        System.out.println( candle);
        System.out.println( list.size());
        System.out.println( list);

    }

}