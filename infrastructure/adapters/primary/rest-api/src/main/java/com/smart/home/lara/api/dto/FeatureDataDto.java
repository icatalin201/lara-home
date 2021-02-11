package com.smart.home.lara.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class FeatureDataDto {
  private Double value;
  private LocalDateTime recordedOn;
}
