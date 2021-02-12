package com.smart.home.lara.core.application.port.primary.impl;

import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.Room;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
@RequiredArgsConstructor
public class LaraPortImpl implements LaraPort {

  private final RoomRepository roomRepository;
  private final FeatureRepository featureRepository;

  @Override
  public Mono<Room> createRoom(Room room) {
    return roomRepository.create(room);
  }

  @Override
  public Mono<Room> findRoomById(UUID id) {
    return roomRepository.findById(id);
  }

  @Override
  public Mono<Feature> createFeature(UUID roomId, Feature feature) {
    feature.setRoomId(roomId);
    return roomRepository
        .findById(roomId)
        .zipWith(featureRepository.create(feature))
        .flatMap(
            tuple -> {
              tuple.getT1().getFeatures().add(feature);
              return roomRepository.update(tuple.getT1()).zipWith(Mono.just(tuple.getT2()));
            })
        .map(Tuple2::getT2);
  }
}
