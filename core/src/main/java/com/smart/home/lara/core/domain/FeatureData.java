package com.smart.home.lara.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class FeatureData {
  private UUID id;
  private Double value;
  private LocalDateTime recordedOn;
  private Feature feature;
}
