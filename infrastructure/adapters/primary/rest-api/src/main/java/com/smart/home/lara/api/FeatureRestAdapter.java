package com.smart.home.lara.api;

import com.smart.home.lara.api.dto.FeatureDto;
import com.smart.home.lara.core.application.port.primary.FeaturePort;
import com.smart.home.lara.core.domain.Feature;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

/** lara Created by Catalin on 2/11/2021 */
@RestController
@RequestMapping("/api/v1/features")
@RequiredArgsConstructor
public class FeatureRestAdapter {

  private final FeaturePort featurePort;
  private final ModelMapper modelMapper;

  @PostMapping
  public Mono<FeatureDto> create(@Valid @RequestBody FeatureDto featureDto) {
    Feature feature = modelMapper.map(featureDto, Feature.class);
    return featurePort
        .create(feature)
        .map(featureCreated -> modelMapper.map(featureCreated, FeatureDto.class));
  }

  @GetMapping
  public Flux<FeatureDto> findAllByRoom(@Valid @RequestParam UUID roomId) {
    return featurePort
        .findAllByRoom(roomId)
        .map(feature -> modelMapper.map(feature, FeatureDto.class));
  }
}
