package com.smart.home.lara.core.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class Feature {
  private UUID id;
  private String name;
  private FeatureType type;
  private Room room;
  private FeatureData lastRecordedData;
  private List<FeatureData> dataHistory;
}
