package com.smart.home.lara.core.domain.service;

import com.smart.home.lara.core.application.exception.RoomNotFoundException;
import com.smart.home.lara.core.application.port.primary.RoomPort;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.model.Room;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

/** lara Created by icatalin201 on 11.03.2021 */
@RequiredArgsConstructor
public class RoomService implements RoomPort {

  private final RoomRepository roomRepository;

  @Override
  public void create(Room room) {
    roomRepository.create(room);
  }

  @Override
  public Room findById(UUID id) {
    return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
  }

  @Override
  public List<Room> findAll() {
    return roomRepository.findAll();
  }
}
