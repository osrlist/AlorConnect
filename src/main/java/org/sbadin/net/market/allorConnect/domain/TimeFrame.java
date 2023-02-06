package org.sbadin.net.market.allorConnect.domain;


/**
 * Status of a submitted order.
 */
public enum TimeFrame {
  S15("15", 15),
  S60("60", 60),
  S300("300", 300),
  S3600("3600", 3600),
  D("D", 86400),
  W("W", 604800),
  M("M", 18748800),
  Y("Y", 31536000);

  private String value;

  private long inputSec;

  TimeFrame(String value, long inputSec) {
    this.value = value;
    this.inputSec = inputSec;
  }

  public String getValue() {
    return value;
  }

  public long getInputSec() {
    return inputSec;
  }

  @Override
  public String toString() {
    return getValue();
  }
}
