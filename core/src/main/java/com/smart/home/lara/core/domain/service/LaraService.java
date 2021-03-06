package com.smart.home.lara.core.domain.service;

import com.smart.home.lara.core.application.exception.RoomNotFoundException;
import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.model.Feature;
import com.smart.home.lara.core.domain.model.FeatureData;
import com.smart.home.lara.core.domain.model.Room;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
@RequiredArgsConstructor
public class LaraService implements LaraPort {

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
    return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
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
