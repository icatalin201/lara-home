package com.smart.home.lara.core.application.port.secondary;

import com.smart.home.lara.core.domain.Room;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
public interface RoomRepository {
  Mono<Room> create(Room room);

  Mono<Room> findById(UUID id);
}
