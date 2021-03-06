package com.smart.home.lara.core.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@RequiredArgsConstructor
public enum FeatureType {
  TEMPERATURE("°C"),
  HUMIDITY("%");

  private final String unit;
}
