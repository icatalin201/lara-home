package com.smart.home.lara.repo;

import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Room;
import com.smart.home.lara.repo.repository.LaraInMemoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class RoomRepositoryAdapter implements RoomRepository {

  private final LaraInMemoryRepository repository;

  @Override
  public Mono<Room> create(Room room) {
    return repository.createRoom(room);
  }

  @Override
  public Mono<Room> update(Room room) {
    return repository.updateRoom(room);
  }

  @Override
  public Mono<Room> findById(UUID id) {
    return repository.findRoomById(id);
  }
}
