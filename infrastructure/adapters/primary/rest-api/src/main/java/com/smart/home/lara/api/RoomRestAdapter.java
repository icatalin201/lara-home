package com.smart.home.lara.api;

import com.smart.home.lara.api.dto.RoomDto;
import com.smart.home.lara.core.application.port.primary.RoomPort;
import com.smart.home.lara.core.domain.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomRestAdapter {

  private final RoomPort roomPort;
  private final ModelMapper modelMapper;

  @PostMapping
  public Mono<RoomDto> create(@Valid @RequestBody RoomDto roomDto) {
    Room room = modelMapper.map(roomDto, Room.class);
    return roomPort.create(room).map(roomCreated -> modelMapper.map(roomCreated, RoomDto.class));
  }

  @GetMapping("/{id}")
  public Mono<RoomDto> findById(@Valid @PathVariable UUID id) {
    return roomPort.findById(id).map(room -> modelMapper.map(room, RoomDto.class));
  }
}
