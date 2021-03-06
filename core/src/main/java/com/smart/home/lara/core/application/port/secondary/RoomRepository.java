package com.smart.home.lara.core.application.port.secondary;

import com.smart.home.lara.core.domain.model.Room;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface RoomRepository {
  void create(Room room);

  void update(Room room);

  Optional<Room> findById(UUID id);

  List<Room> findAll();
}
