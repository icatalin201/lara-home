package com.smart.home.lara.core.application.port.primary;

import com.smart.home.lara.core.domain.model.Feature;
import com.smart.home.lara.core.domain.model.Room;

import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
public interface LaraPort {
  void createRoom(Room room);

  void createFeature(UUID roomId, Feature feature);

  Room findRoomById(UUID id);

  List<Room> findRooms();

  List<Feature> findFeaturesByRoom(UUID roomId);
}
