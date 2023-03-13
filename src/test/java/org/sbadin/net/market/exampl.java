package org.sbadin.net.market;

import org.sbadin.net.market.allorConnect.AlorApiCallback;
import org.sbadin.net.market.allorConnect.AlorApiClientFactory;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.domain.ContractEventData;
import org.sbadin.net.market.allorConnect.domain.Exchange;

import java.io.Closeable;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class exampl {

    public static void main(String[] args) throws InterruptedException {
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance ( "gfffgdfddadf9");
        AlorApiWebSocketClient client = factory.newWebSocketClient();

        AlorApiCallback<ContractEventData> cb = new AlorApiCallback<ContractEventData>() {
            @Override
            public void onResponse(ContractEventData response) {
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

      Closeable close =  client.onAllTradesGetAndSubscribe("NG-2.23", Exchange.MOEX, 0, false, guid, cb);

       sleep(8000);

        try {
            close.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //client.onUnsubscribe( guid, response -> System.out.println(response));

        System.out.println("all done");
    }
}
