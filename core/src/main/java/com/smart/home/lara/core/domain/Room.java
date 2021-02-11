package com.smart.home.lara.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class Room {
  private UUID id;
  private String name;
  private RoomType type;
}
