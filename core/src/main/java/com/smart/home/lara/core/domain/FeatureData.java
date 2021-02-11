package com.smart.home.lara.core.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Data
public class FeatureData {
  private final UUID id;
  private final Double value;
  private final LocalDateTime recordedOn;
  private final Feature feature;
}
