package com.smart.home.lara.repo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** lara Created by Catalin on 2/12/2021 */
@Getter
@RequiredArgsConstructor
public enum FeatureType {
  TEMPERATURE("°C"),
  HUMIDITY("%");

  private final String unit;
}
