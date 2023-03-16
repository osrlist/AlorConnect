package org.sbadin.net.market.allorConnect.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.sbadin.net.market.allorConnect.AlorApiCallback;
import org.sbadin.net.market.allorConnect.exception.AlorApiException;

import java.io.IOException;

/**
 * Alor API WebSocket listener.
 */
public class AlorApiWebSocketListener<T> extends WebSocketListener {

    private AlorApiCallback<T> callback;

  private static final ObjectMapper mapper = new ObjectMapper();

  private final ObjectReader objectReader;

  private boolean closing = false;

  public AlorApiWebSocketListener(AlorApiCallback<T> callback, Class<T> eventClass) {
    this.callback = callback;
    this.objectReader = mapper.readerFor(eventClass);
  }

  public AlorApiWebSocketListener(AlorApiCallback<T> callback, TypeReference<T> eventTypeReference) {
    this.callback = callback;
    this.objectReader = mapper.readerFor(eventTypeReference);
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
      if (!text.startsWith("{\"requestGuid\":")) {
          try {
            T event = objectReader.readValue(text);
            callback.onResponse(event);
          } catch (IOException e) {
            throw new AlorApiException(e);
          }
      } else {
         System.out.println(text);
      }
  }

  @Override
  public void onClosing(final WebSocket webSocket, final int code, final String reason) {
     closing = true;
     System.out.println("Close webSocket");
  }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    if (!closing) {
      callback.onFailure(t);
    }
  }

  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    System.out.println( "open" );
  }
}