package org.sbadin.net.market.allorConnect.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.sbadin.net.market.allorConnect.AlorApiCallback;
import org.sbadin.net.market.allorConnect.AlorApiWebSocketClient;
import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.domain.ContractEventData;
import org.sbadin.net.market.allorConnect.domain.EventData;
import org.sbadin.net.market.allorConnect.domain.Exchange;
import org.sbadin.net.market.allorConnect.domain.TradeEventData;

import java.io.Closeable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Alor API WebSocket client implementation using OkHttp.
 */
public class AlorApiWebSocketClientImpl implements AlorApiWebSocketClient, Closeable {

    private final OkHttpClient client;
    private final String secret;

    private final AlorApiRestNonSecurityClientImpl authorToken;
    private final ObjectMapper objectMapper ;

    public AlorApiWebSocketClientImpl(OkHttpClient client, String secret) {
        this.client = client;
        this.secret = secret;
        this.authorToken = new AlorApiRestNonSecurityClientImpl();

        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSSZ"));

    }

    private Closeable createNewWebSocket(Map<String, Object> objectMap, String guid, AlorApiWebSocketListener<?> listener)  {
        String streamingUrl = String.format("%s", AlorApiConfig.getStreamApiBaseUrl());

        Request request = new Request.Builder()
                .url(streamingUrl)
                .build();
        final WebSocket webSocket = client.newWebSocket(request, listener);

       objectMap.put("token", authorToken.getCacheAccessToken(secret));
       objectMap.put("guid", guid);

        String xml = null;
        try {
            xml = objectMapper.writeValueAsString(objectMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        webSocket.send(xml);
        return () -> {
            final int code = 1000;
            String unSubscribe = String.format("{\"opcode\":\"unsubscribe\",\"token\": \"%s\",\"guid\": \"%s\"}",  authorToken.getCacheAccessToken(secret), guid );
            webSocket.send( unSubscribe );

            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }

    @Override
    public Closeable onAllTradesGetAndSubscribe(String symbol, Exchange exchange, Integer depth, Boolean includeVirtualTrades, String guid, AlorApiCallback<ContractEventData> callback) {
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("opcode", "AllTradesGetAndSubscribe");
        objectMap.put("code", symbol);
        objectMap.put("exchange", exchange.name());
        objectMap.put("format", "Simple");
        objectMap.put("depth", depth);
        objectMap.put("includeVirtualTrades", includeVirtualTrades);

        return createNewWebSocket(objectMap, guid, new AlorApiWebSocketListener<>(callback, ContractEventData.class));
    }
    @Override
    public Closeable onTradesGetAndSubscribeV2(String portfolio, Exchange exchange, String guid, AlorApiCallback<TradeEventData> callback) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("opcode", "TradesGetAndSubscribeV2");
        objectMap.put("portfolio", portfolio);
        objectMap.put("exchange", exchange.name());
        objectMap.put("format", "Simple");

        return createNewWebSocket(objectMap, guid, new AlorApiWebSocketListener<>(callback, TradeEventData.class));
    }

    @Override
    public Closeable onUnsubscribe(String guid, AlorApiCallback<EventData> callback) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("opcode", "unsubscribe");
        objectMap.put("guid", guid);

        return createNewWebSocket(objectMap, guid,  new AlorApiWebSocketListener<>(callback, EventData.class));
    }

    @Override
    public void close() throws IOException {
        System.out.println("close webSocket");
    }
}
