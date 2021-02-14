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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomRestAdapter {

  private final LaraPort laraPort;
  private final ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createRoom(@Valid @RequestBody CreateRoomDto createRoomDto) {
    Room room = modelMapper.map(createRoomDto, Room.class);
    laraPort.createRoom(room);
  }

  @GetMapping
  public Flux<RoomDto> findRooms() {
    List<Room> rooms = laraPort.findRooms();
    return Flux.fromStream(rooms.stream().map(room -> modelMapper.map(room, RoomDto.class)));
  }

  @GetMapping("/{roomId}")
  public Mono<RoomDto> findRoomById(@Valid @PathVariable UUID roomId) {
    Room room = laraPort.findRoomById(roomId);
    return Mono.just(modelMapper.map(room, RoomDto.class));
  }

  @PostMapping("/{roomId}/features")
  public void createFeature(
      @Valid @PathVariable UUID roomId, @Valid @RequestBody CreateFeatureDto createFeatureDto) {
    Feature feature = modelMapper.map(createFeatureDto, Feature.class);
    laraPort.createFeature(roomId, feature);
  }

  @GetMapping("/{roomId}/features")
  public Flux<FeatureDto> findFeaturesByRoom(@Valid @PathVariable UUID roomId) {
    List<Feature> features = laraPort.findFeaturesByRoom(roomId);
    return Flux.fromStream(
        features.stream().map(feature -> modelMapper.map(feature, FeatureDto.class)));
  }
}
