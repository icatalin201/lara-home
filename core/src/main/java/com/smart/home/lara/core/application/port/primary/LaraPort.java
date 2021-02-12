package com.smart.home.lara.core.application.port.primary;

import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.Room;
import reactor.core.publisher.Mono;

import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
public interface LaraPort {
  Mono<Room> createRoom(Room room);

  Mono<Room> findRoomById(UUID id);

  Mono<Feature> createFeature(UUID roomId, Feature feature);
}
