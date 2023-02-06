package org.sbadin.net.market.allorConnect.exception;

import org.sbadin.net.market.allorConnect.AlorApiError;

/**
 * An exception which can occur while invoking methods of the alor API.
 */
public class AlorApiException extends RuntimeException {

  private static final long serialVersionUID = -2155863099988931263L;
/**
   * Error response object returned by Alor API.
   */
  private AlorApiError error;

  /**
   * Instantiates a new alor api exception.
   *
   * @param error an error response object
   */
  public AlorApiException(AlorApiError error) {
    this.error = error;
  }

  /**
   * Instantiates a new alor api exception.
   */
  public AlorApiException() {
    super();
  }

  /**
   * Instantiates a new alor api exception.
   *
   * @param message the message
   */
  public AlorApiException(String message) {
    super(message);
  }

  /**
   * Instantiates a new alor api exception.
   *
   * @param cause the cause
   */
  public AlorApiException(Throwable cause) {
    super(cause);
  }

  /**
   * Instantiates a new alor api exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public AlorApiException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @return the response error object from alor API, or null if no response object was returned (e.g. server returned 500).
   */
  public AlorApiError getError() {
    return error;
  }

  @Override
  public String getMessage() {
    if (error != null) {
      return error.getMessage()+ "  HTTP Code = " + error.getCode();
    }
    return super.getMessage();
  }
}
