package com.smart.home.lara.api.dto;

import com.smart.home.lara.core.domain.RoomType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** lara Created by Catalin on 2/12/2021 */
@Getter
@Setter
public class CreateRoomDto {
  @NotBlank private String name;
  @NotNull private RoomType type;
}
