package com.smart.home.lara.repository;

import com.smart.home.lara.core.domain.Room;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public class RoomInMemoryRepository {

  private final List<Room> rooms = new ArrayList<>();

  public Mono<Room> create(Room room) {
    rooms.add(room);
    return Mono.just(room);
  }

  public Mono<Room> findById(UUID id) {
    return rooms.stream()
        .filter(room -> room.getId() == id)
        .findFirst()
        .map(Mono::just)
        .orElse(Mono.empty());
  }
}
