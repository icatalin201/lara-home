package com.smart.home.lara.core.application.port.primary.impl;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.core.domain.Room;
import lombok.RequiredArgsConstructor;

/** lara Created by Catalin on 2/12/2021 */
@RequiredArgsConstructor
public class LaraPortImpl implements LaraPort {

  private final RoomRepository roomRepository;
  private final FeatureRepository featureRepository;

  @Override
  public void createRoom(Room room) {
    roomRepository.create(room);
  }

  @Override
  public void createFeature(UUID roomId, Feature feature) {
    Room room = findRoomById(roomId);
    feature.setRoom(room);
    featureRepository.create(feature);
  }

  @Override
  public Room findRoomById(UUID id) {
    return roomRepository.findById(id);
  }

  @Override
  public List<Room> findRooms() {
    return roomRepository.findAll();
  }

  @Override
  public List<Feature> findFeaturesByRoom(UUID roomId) {
    List<Feature> features = featureRepository.findAllByRoom(roomId);
    features.forEach(this::updateFeatureWithLastData);
    return features;
  }

  private void updateFeatureWithLastData(Feature feature) {
    FeatureData featureData =
        feature.getDataHistory().stream()
            .max(Comparator.comparing(FeatureData::getRecordedOn))
            .orElse(null);
    feature.setLastRecordedData(featureData);
  }
}
