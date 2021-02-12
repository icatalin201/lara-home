package com.smart.home.lara.core.application.port.primary.impl;

import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.application.port.secondary.FeatureRepository;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureData;
import com.smart.home.lara.core.domain.Room;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

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
    Room room = roomRepository.findById(id);
    room.setFeatures(featureRepository.findAllByRoom(id));
    room.getFeatures().forEach(this::updateFeatureWithLastData);
    return room;
  }

  @Override
  public List<Room> findRooms() {
    List<Room> rooms = roomRepository.findAll();
    rooms.forEach(
        room -> {
          room.setFeatures(featureRepository.findAllByRoom(room.getId()));
          room.getFeatures().forEach(this::updateFeatureWithLastData);
        });
    return rooms;
  }

  private void updateFeatureWithLastData(Feature feature) {
    FeatureData featureData =
        feature.getDataHistory().stream()
            .max(Comparator.comparing(FeatureData::getRecordedOn))
            .orElse(null);
    feature.setLastRecordedData(featureData);
  }
}
