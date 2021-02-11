package com.smart.home.lara.repo;

import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Room;
import com.smart.home.lara.repo.repository.RoomInMemoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class RoomRepositoryAdapter implements RoomRepository {

  private final RoomInMemoryRepository roomInMemoryRepository;

  @Override
  public Room create(Room room) {
    return roomInMemoryRepository.create(room);
  }

  @Override
  public Room findById(UUID id) {
    return roomInMemoryRepository.findById(id);
  }
}
