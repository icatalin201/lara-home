package com.smart.home.lara.api.dto;

import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.core.domain.FeatureType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class FeatureDto {
  private UUID id;
  @NotBlank private String name;
  @NotNull private FeatureType type;
  private FeatureDataDto lastRecordedData;
}
