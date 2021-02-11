package com.smart.home.lara.api.dto;

import com.smart.home.lara.core.domain.RoomType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class RoomDto {
  private UUID id;
  @NotBlank private String name;
  @NotNull private RoomType type;
}
