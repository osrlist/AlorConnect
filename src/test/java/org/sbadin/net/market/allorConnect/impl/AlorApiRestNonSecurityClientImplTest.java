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
import org.sbadin.net.market.allorConnect.domain.general.History;

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
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance ( "ffff-fff-f-f-f-f-ffff");
        AlorApiRestClient client = factory.newRestClient();
        History candle = client.getHistory("NGF3", "MOEX", TimeFrame.S60, 1673642940L, 1673642940L);
        System.out.println( candle);
    }

}