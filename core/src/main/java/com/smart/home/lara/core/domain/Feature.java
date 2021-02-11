package com.smart.home.lara.core.domain;

import lombok.Data;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Data
public class Feature {
  private final UUID id;
  private final Boolean active;
  private final String name;
  private final FeatureType type;
  private final Room room;
}
