package com.smart.home.lara.repo;

import com.smart.home.lara.core.application.exception.RoomNotFoundException;
import com.smart.home.lara.core.application.port.secondary.RoomRepository;
import com.smart.home.lara.core.domain.Room;
import com.smart.home.lara.repo.entity.RoomEntity;
import com.smart.home.lara.repo.repository.RoomJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/** lara Created by Catalin on 2/11/2021 */
@RequiredArgsConstructor
public class RoomRepositoryAdapter implements RoomRepository {

  private final ModelMapper modelMapper;
  private final RoomJpaRepository roomJpaRepository;

  @Override
  @Transactional
  public void create(Room room) {
    RoomEntity entity = modelMapper.map(room, RoomEntity.class);
    roomJpaRepository.save(entity);
  }

  @Override
  @Transactional
  public void update(Room room) {
    if (room.getId() == null) {
      throw new IllegalStateException();
    }
    RoomEntity entity = modelMapper.map(room, RoomEntity.class);
    roomJpaRepository.save(entity);
  }

  @Override
  @Transactional
  public Room findById(UUID id) {
    return roomJpaRepository
        .findById(id)
        .map(roomEntity -> modelMapper.map(roomEntity, Room.class))
        .orElseThrow(RoomNotFoundException::new);
  }

  @Override
  @Transactional
  public List<Room> findAll() {
    return roomJpaRepository.findAll().stream()
        .map(roomEntity -> modelMapper.map(roomEntity, Room.class))
        .collect(Collectors.toList());
  }
}
