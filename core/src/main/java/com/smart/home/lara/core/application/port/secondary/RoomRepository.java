package com.smart.home.lara.core.application.port.secondary;

import com.smart.home.lara.core.domain.Room;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface RoomRepository {
  Room create(Room room);

  Room findById(UUID id);
}
