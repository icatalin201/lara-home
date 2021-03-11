package com.smart.home.lara.core.application.port.primary;

import com.smart.home.lara.core.domain.model.Room;

import java.util.List;
import java.util.UUID;

/** lara Created by icatalin201 on 11.03.2021 */
public interface RoomPort {

  void create(Room room);

  Room findById(UUID id);

  List<Room> findAll();
}
