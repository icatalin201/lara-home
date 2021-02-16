package com.smart.home.lara.api.dto;

import java.util.UUID;

import com.smart.home.lara.core.domain.RoomType;
import lombok.Getter;
import lombok.Setter;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class RoomDto {
  private UUID id;
  private String name;
  private RoomType type;
}
