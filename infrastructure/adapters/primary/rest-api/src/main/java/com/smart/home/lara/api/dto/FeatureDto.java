package com.smart.home.lara.api.dto;

import com.smart.home.lara.core.domain.FeatureType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class FeatureDto {
  private UUID id;
  private String name;
  private FeatureType type;
  private UUID roomId;
  private FeatureDataDto lastRecordedData;
}
