package com.smart.home.lara.repo.repository;

import com.smart.home.lara.core.domain.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public class RoomInMemoryRepository {

  private final List<Room> rooms = new ArrayList<>();

  public Room create(Room room) {
    rooms.add(room);
    return room;
  }

  public Room findById(UUID id) {
    return rooms.stream().filter(room -> room.getId() == id).findFirst().orElseThrow();
  }
}
