package com.smart.home.lara.core.domain;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/** lara Created by Catalin on 2/11/2021 */
@Getter
@Setter
public class Room {
  private UUID id;
  private String name;
  private RoomType type;
}
