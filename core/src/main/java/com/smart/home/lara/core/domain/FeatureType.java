package com.smart.home.lara.core.domain;

/** lara Created by Catalin on 2/11/2021 */
public enum FeatureType {
  TEMPERATURE("°C"),
  HUMIDITY("%");

  private final String unit;

  FeatureType(String unit) {
    this.unit = unit;
  }

  public String getUnit() {
    return unit;
  }
}
