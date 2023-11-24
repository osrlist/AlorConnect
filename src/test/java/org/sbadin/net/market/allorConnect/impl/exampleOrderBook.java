package org.sbadin.net.market.allorConnect.impl;

import org.sbadin.net.market.allorConnect.AlorApiCallback;
import org.sbadin.net.market.allorConnect.AlorApiClientFactory;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.domain.ContractEventData;
import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.OrderBook;

import java.io.Closeable;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class exampleOrderBook {

    public static void main(String[] args) throws InterruptedException {
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance ( "b5sdfadfadsf9");
        AlorApiWebSocketClient client = factory.newWebSocketClient();

        AlorApiCallback<OrderBook> cb = new AlorApiCallback<OrderBook>() {
            @Override
            public void onResponse(OrderBook response) {
                System.out.println( response );
            }

            @Override
            public void onFailure(Throwable cause) {
                System.out.println("cause");
                System.out.println(cause);
            }
        };


/*        client.onAllTradesGetAndSubscribe("NGF3", Exchange.MOEX, 10, false, java.util.UUID.randomUUID().toString(),
                response -> System.out.println(response));

 */

      String guid = java.util.UUID.randomUUID().toString();

      Closeable close = client.onOrderBookGetAndSubscribe("NG-11.23", Exchange.MOEX, 10, guid, cb);

       sleep(8000);

        try {
            close.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        client.onUnsubscribe( guid, response -> System.out.println(response));

        System.out.println("all done");
    }
}
