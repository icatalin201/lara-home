package com.smart.home.lara.core.application.port.secondary;

import com.smart.home.lara.core.domain.Room;

import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface RoomRepository {
  void create(Room room);

  void update(Room room);

  Room findById(UUID id);

  List<Room> findAll();
}
