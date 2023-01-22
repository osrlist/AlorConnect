package org.sbadin.net.market.allorConnect.domain;


/**
 * Status of a submitted order.
 */
public enum TimeFrame {
  S15("15"),
  S60("60"),
  S300("300"),
  S3600("3600"),
  D("D"),
  W("W"),
  M("M"),
  Y("Y");

  private String value;

  TimeFrame(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }


  @Override
  public String toString() {
    return getValue();
  }
}
