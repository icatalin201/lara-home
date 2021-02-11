package com.smart.home.lara.core.domain;

import lombok.Data;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@Data
public class Room {
  private final UUID id;
  private final String name;
  private final Boolean enabled;
  private final RoomType type;
}
