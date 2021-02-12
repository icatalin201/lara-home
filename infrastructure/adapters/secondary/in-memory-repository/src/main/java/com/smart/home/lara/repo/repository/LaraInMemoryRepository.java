package com.smart.home.lara.repo.repository;

import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.core.domain.Room;
import com.smart.home.lara.repo.entity.FeatureDataEntity;
import com.smart.home.lara.repo.entity.FeatureEntity;
import com.smart.home.lara.repo.entity.RoomEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
@RequiredArgsConstructor
public class LaraInMemoryRepository {

  private final Set<RoomEntity> rooms = new HashSet<>();
  private final Set<FeatureEntity> features = new HashSet<>();
  private final Set<FeatureDataEntity> data = new HashSet<>();

  private final ModelMapper modelMapper;

  public Mono<Room> createRoom(Room room) {
    room.setId(UUID.randomUUID());
    RoomEntity roomEntity = modelMapper.map(room, RoomEntity.class);
    rooms.add(roomEntity);
    return Mono.just(modelMapper.map(roomEntity, Room.class));
  }

  public Mono<Room> updateRoom(Room room) {
    RoomEntity roomEntity = modelMapper.map(room, RoomEntity.class);
    rooms.remove(roomEntity);
    rooms.add(roomEntity);
    return Mono.just(modelMapper.map(roomEntity, Room.class));
  }

  public Mono<Room> findRoomById(UUID id) {
    return Mono.justOrEmpty(
        rooms.stream()
            .filter(room -> room.getId() == id)
            .findFirst()
            .map(roomEntity -> modelMapper.map(roomEntity, Room.class)));
  }

  public Mono<Feature> createFeature(Feature feature) {
    feature.setId(UUID.randomUUID());
    FeatureEntity featureEntity = modelMapper.map(feature, FeatureEntity.class);
    RoomEntity roomEntity = findRoom(feature.getRoomId());
    roomEntity.getFeatures().add(featureEntity);
    rooms.remove(roomEntity);
    rooms.add(roomEntity);
    return Mono.just(modelMapper.map(featureEntity, Feature.class));
  }

  public Mono<Feature> findFeatureById(UUID id) {
    return Mono.justOrEmpty(
        features.stream()
            .filter(feature -> feature.getId() == id)
            .findFirst()
            .map(featureEntity -> modelMapper.map(featureEntity, Feature.class)));
  }

  public Flux<Feature> findAllFeaturesByRoom(UUID roomId) {
    return Flux.fromStream(features.stream().filter(feature -> feature.getRoomId() == roomId));
  }

  public Flux<FeatureData> findAllDataByFeature(UUID featureId) {
    return Flux.fromStream(
        featureDataHistory.stream().filter(data -> data.getFeatureId() == featureId));
  }

  public Mono<FeatureData> recordData(FeatureData featureData) {
    featureDataHistory.add(featureData);
    return Mono.just(featureData);
  }

  private RoomEntity findRoom(UUID roomId) {
    return rooms.stream()
        .filter(roomEntity -> roomEntity.getId() == roomId)
        .findAny()
        .orElseThrow();
  }
}
