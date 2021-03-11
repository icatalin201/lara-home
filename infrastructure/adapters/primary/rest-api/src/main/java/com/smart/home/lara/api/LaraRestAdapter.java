package com.smart.home.lara.api;

import com.smart.home.lara.api.dto.CreateFeatureDto;
import com.smart.home.lara.api.dto.CreateRoomDto;
import com.smart.home.lara.api.dto.FeatureDto;
import com.smart.home.lara.api.dto.RoomDto;
import com.smart.home.lara.core.application.port.primary.FeaturePort;
import com.smart.home.lara.core.application.port.primary.RoomPort;
import com.smart.home.lara.core.domain.model.Feature;
import com.smart.home.lara.core.domain.model.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class LaraRestAdapter {

  private final RoomPort roomPort;
  private final FeaturePort featurePort;
  private final ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createRoom(@Valid @RequestBody CreateRoomDto createRoomDto) {
    Room room = modelMapper.map(createRoomDto, Room.class);
    roomPort.create(room);
  }

  @PostMapping("/{roomId}/features")
  @ResponseStatus(HttpStatus.CREATED)
  public void createFeature(
      @Valid @PathVariable UUID roomId, @Valid @RequestBody CreateFeatureDto createFeatureDto) {
    Feature feature = modelMapper.map(createFeatureDto, Feature.class);
    featurePort.create(roomId, feature);
  }

  @GetMapping
  public Flux<RoomDto> findRooms() {
    List<Room> rooms = roomPort.findAll();
    return Flux.fromStream(rooms.stream().map(room -> modelMapper.map(room, RoomDto.class)));
  }

  @GetMapping("/{roomId}")
  public Mono<RoomDto> findRoomById(@Valid @PathVariable UUID roomId) {
    Room room = roomPort.findById(roomId);
    return Mono.just(modelMapper.map(room, RoomDto.class));
  }

  @GetMapping("/{roomId}/features")
  public Flux<FeatureDto> findFeaturesByRoom(@Valid @PathVariable UUID roomId) {
    List<Feature> features = featurePort.findAllByRoom(roomId);
    return Flux.fromStream(
        features.stream().map(feature -> modelMapper.map(feature, FeatureDto.class)));
  }
}
