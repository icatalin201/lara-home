package com.smart.home.lara.api.dto;

import com.smart.home.lara.core.domain.RoomType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class RoomDto {
  private UUID id;
  private String name;
  private RoomType type;
  private List<FeatureDto> features;
}
