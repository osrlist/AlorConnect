package org.sbadin.net.market.allorConnect;


import org.sbadin.net.market.allorConnect.impl.AlorApiRestClientImpl;
import org.sbadin.net.market.allorConnect.config.AlorApiConfig;
import org.sbadin.net.market.allorConnect.impl.AlorApiWebSocketClientImpl;

import static org.sbadin.net.market.allorConnect.impl.AlorApiServiceGenerator.getSharedClient;

/**
 * A factory for creating AlorApi client objects.
 */
public class AlorApiClientFactory {
  /**
   * Secret.
   */
  private String secret;

  /**
   *
   * @param secret the Secret
   */
  private AlorApiClientFactory(String secret) {
    this.secret = secret;
    AlorApiConfig.useTestnet = false;
  }

  /**
   * Instantiates a new Alor api client factory.
   *
   * @param secret the Secret
   */
  private AlorApiClientFactory(String secret, boolean useTestnet) {
      this(secret);
      AlorApiConfig.useTestnet = useTestnet;
  }

  /**
   * New instance.
   *
   * @param secret the Secret
   *
   * @return the Alor api client factory
   */
  public static AlorApiClientFactory newInstance(String secret) {
    return new AlorApiClientFactory(secret);
  }

  /**
   * Creates a new synchronous/blocking REST client.
   */
  public AlorApiRestClient newRestClient() {
    return new AlorApiRestClientImpl(secret);
  }


  /**
   * Creates a new web socket client used for handling data streams.
   */
  public AlorApiWebSocketClient newWebSocketClient() {
    return new AlorApiWebSocketClientImpl(getSharedClient(), secret);
  }

}
