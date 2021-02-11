package com.smart.home.lara;

import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Room;
import com.smart.home.lara.repository.RoomInMemoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class RoomRepositoryAdapter implements RoomRepository {

  private final RoomInMemoryRepository roomInMemoryRepository;

  @Override
  public Mono<Room> create(Room room) {
    return roomInMemoryRepository.create(room);
  }

  @Override
  public Mono<Room> findById(UUID id) {
    return roomInMemoryRepository.findById(id);
  }
}
