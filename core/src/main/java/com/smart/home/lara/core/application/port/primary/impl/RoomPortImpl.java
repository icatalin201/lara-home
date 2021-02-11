package com.smart.home.lara.core.application.port.primary.impl;

import com.smart.home.lara.core.application.port.primary.RoomPort;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Room;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class RoomPortImpl implements RoomPort {

  private final RoomRepository roomRepository;

  @Override
  public Mono<Room> create(Room room) {
    room.setId(UUID.randomUUID());
    Room createdRoom = roomRepository.create(room);
    return Mono.just(createdRoom);
  }

  @Override
  public Mono<Room> findById(UUID id) {
    Room room = roomRepository.findById(id);
    return Mono.just(room);
  }
}
