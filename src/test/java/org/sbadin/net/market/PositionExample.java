package org.sbadin.net.market;

import org.sbadin.net.market.allorConnect.AlorApiCallback;
import org.sbadin.net.market.allorConnect.AlorApiClientFactory;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.PositionEventData;
import org.sbadin.net.market.allorConnect.domain.StopLimitEventData;

import java.io.Closeable;
import java.io.IOException;

public class PositionExample {

    public static void main(String[] args) throws InterruptedException, IOException {
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance( "lkjlkj;lkj;lkj;lkj;lkj");
        AlorApiWebSocketClient client = factory.newWebSocketClient();

        AlorApiCallback<PositionEventData> cb = new AlorApiCallback<PositionEventData>() {
            @Override
            public void onResponse(PositionEventData response) {
                System.out.println( response );

                System.out.println( "----------------------------------------------" );

            }

            @Override
            public void onFailure(Throwable cause) {
                System.out.println("cause");
                System.out.println(cause);
            }
        };


        String guid = java.util.UUID.randomUUID().toString();

        Closeable close =  client.onPositionV2("13213213", Exchange.MOEX, guid, cb);

//        close.close();

        System.out.println("all done");
    }
}
