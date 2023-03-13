import org.sbadin.net.market.allorConnect.AlorApiCallback;
import org.sbadin.net.market.allorConnect.AlorApiClientFactory;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.TradeEventData;

import java.io.Closeable;
import java.io.IOException;

public class OrderExample {

    public static void main(String[] args) throws InterruptedException, IOException {
        AlorApiClientFactory factory = AlorApiClientFactory.newInstance( "bffffffffffffffffff");
        AlorApiWebSocketClient client = factory.newWebSocketClient();

        AlorApiCallback<TradeEventData> cb = new AlorApiCallback<TradeEventData>() {
            @Override
            public void onResponse(TradeEventData response) {
                System.out.println( response );
            }

            @Override
            public void onFailure(Throwable cause) {
                System.out.println("cause");
                System.out.println(cause);
            }
        };


        String guid = java.util.UUID.randomUUID().toString();

        Closeable close =  client.onTradesGetAndSubscribeV2("11111111111111", Exchange.MOEX, guid, cb);

        close.close();

        System.out.println("all done");
    }
}
