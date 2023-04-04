import org.sbadin.net.market.allorConnect.AlorApiCallback;
import org.sbadin.net.market.allorConnect.AlorApiClientFactory;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.StopLimitEventData;

import java.io.Closeable;
import java.io.IOException;

public class StopLimitExample {

    public static void main(String[] args) throws InterruptedException, IOException {
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance( "dfadfasdfdsfdfsd-dsfadfsdfsddf");
        AlorApiWebSocketClient client = factory.newWebSocketClient();

        AlorApiCallback<StopLimitEventData> cb = new AlorApiCallback<StopLimitEventData>() {
            @Override
            public void onResponse(StopLimitEventData response) {
                System.out.println( response );
            }

            @Override
            public void onFailure(Throwable cause) {
                System.out.println("cause");
                System.out.println(cause);
            }
        };


        String guid = java.util.UUID.randomUUID().toString();

        Closeable close =  client.onStopOrdersGetAndSubscribeV2("564654", Exchange.MOEX, guid, cb);

//        close.close();

        System.out.println("all done");
    }
}
