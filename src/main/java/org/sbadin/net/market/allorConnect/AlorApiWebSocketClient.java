package org.sbadin.net.market.allorConnect;

import org.sbadin.net.market.allorConnect.domain.*;

import java.io.Closeable;

/**
 * Alor API data streaming facade, supporting streaming of events through web sockets.
 */
public interface AlorApiWebSocketClient extends Closeable {

    Closeable onAllTradesGetAndSubscribe(String symbols, Exchange exchange, Integer depth, Boolean includeVirtualTrades,
                                         String guid, AlorApiCallback<ContractEventData> callback);
    Closeable onTradesGetAndSubscribeV2(String portfolio, Exchange exchange, String guid, AlorApiCallback<TradeEventData> callback);

    Closeable onStopOrdersGetAndSubscribeV2(String portfolio, Exchange exchange, String guid, AlorApiCallback<StopLimitEventData> callback);
    Closeable onPositionV2(String portfolio, Exchange exchange, String guid, AlorApiCallback<PositionEventData> callback);

    Closeable onUnsubscribe(String guid, AlorApiCallback<EventData> callback);

    Closeable onOrderBookGetAndSubscribe(String symbols, Exchange exchange, Integer depth, String guid, AlorApiCallback<OrderBook> callback);

}
