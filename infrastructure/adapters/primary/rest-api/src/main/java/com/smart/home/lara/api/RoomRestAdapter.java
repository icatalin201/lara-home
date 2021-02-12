package com.smart.home.lara.api;

import com.smart.home.lara.api.dto.CreateFeatureDto;
import com.smart.home.lara.api.dto.CreateRoomDto;
import com.smart.home.lara.api.dto.FeatureDto;
import com.smart.home.lara.api.dto.RoomDto;
import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomRestAdapter {

  private final LaraPort laraPort;
  private final ModelMapper modelMapper;

  @PostMapping
  public Mono<RoomDto> createRoom(@Valid @RequestBody CreateRoomDto createRoomDto) {
    Room room = modelMapper.map(createRoomDto, Room.class);
    return laraPort
        .createRoom(room)
        .map(roomCreated -> modelMapper.map(roomCreated, RoomDto.class));
  }

  @GetMapping("/{roomId}")
  public Mono<RoomDto> findRoomById(@Valid @PathVariable UUID roomId) {
    return laraPort.findRoomById(roomId).map(room -> modelMapper.map(room, RoomDto.class));
  }

  @PostMapping("/{roomId}/features")
  public Mono<FeatureDto> createFeature(
      @Valid @PathVariable UUID roomId, @Valid @RequestBody CreateFeatureDto createFeatureDto) {
    Feature feature = modelMapper.map(createFeatureDto, Feature.class);
    return laraPort
        .createFeature(roomId, feature)
        .map(featureCreated -> modelMapper.map(featureCreated, FeatureDto.class));
  }
}
