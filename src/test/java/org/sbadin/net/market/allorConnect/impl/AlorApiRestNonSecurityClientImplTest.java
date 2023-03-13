package org.sbadin.net.market.allorConnect.impl;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.sbadin.net.market.allorConnect.AlorApiClientFactory;
import org.sbadin.net.market.allorConnect.AlorApiRestClient;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.domain.*;
import org.sbadin.net.market.allorConnect.domain.general.Candle;
import org.sbadin.net.market.allorConnect.domain.general.History;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.Thread.sleep;

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
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance ( "fffffff-f-f-f--ff");
        AlorApiRestClient client = factory.newRestClient();

        Long endTime = System.currentTimeMillis();
        endTime = endTime / 1000;

        TimeFrame tf = TimeFrame.D;
        int countCandle = 5;

        History candle = client.getHistory("NG-2.23", Exchange.MOEX, tf, endTime, endTime);
        endTime = candle.getPrev();
        candle = client.getHistory("NG-2.23", Exchange.MOEX, tf, endTime - countCandle * tf.getInputSec(), endTime);

        System.out.println( candle.getHistories().size());

        List<Candle> list = candle.getHistories();
        while (list.size() < countCandle) {
            System.out.println( "не все получено");
            endTime = candle.getPrev();
            long mooCandle =  countCandle - list.size();
            candle = client.getHistory("NG-2.23", Exchange.MOEX, tf, endTime - mooCandle * tf.getInputSec(), endTime);
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

    @Ignore
    @Test
    public void callDate() throws InterruptedException {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2023,2,6,12, 59,59);
        calendar.set(Calendar.MILLISECOND, 400);
        System.out.println( calendar.getTime() );
        System.out.println(System.currentTimeMillis());

        while ( !new Date().after( calendar.getTime() )) {
//            System.out.println( "ждем" );
//            System.out.println( new Date() );
//            sleep(10);
        }
        System.out.println( "дождались " );

        String pattern = "MM-dd-yyyy HH:mm:ss SSSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);


         testNewOrder();

    }

    @Ignore
    @Test
    public void testNewOrder() throws InterruptedException {
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance ( "ffff--ff-f-f-f-f-ff");
        AlorApiRestClient client = factory.newRestClient();

        String pattern = "MM-dd-yyyy HH:mm:ss SSSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);


        boolean t = true;
        while (t) {
            try {
                date = simpleDateFormat.format(new Date());
                System.out.println(date);

                OrderActions candle = client.limitOrder("1111111", Side.buy, 1, new BigDecimal("2.940"), "NG-3.23", Exchange.MOEX);
                t = false;
                System.out.println(candle);
            }
            catch ( Exception e) {
                System.out.println( e.getMessage() );
                sleep(100);
            }
        }
        OrderActions candle = client.limitOrder("111111111111", Side.sell, 1, new BigDecimal("2.190"), "NG-3.23", Exchange.MOEX);
    }




}