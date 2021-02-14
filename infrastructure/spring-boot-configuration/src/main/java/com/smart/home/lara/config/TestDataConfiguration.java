package com.smart.home.lara.config;

import com.smart.home.lara.core.application.port.primary.LaraPort;
import com.smart.home.lara.core.domain.Feature;
import com.smart.home.lara.core.domain.FeatureType;
import com.smart.home.lara.core.domain.Room;
import com.smart.home.lara.core.domain.RoomType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

/** lara Created by Catalin on 2/14/2021 */
@Configuration
@RequiredArgsConstructor
public class TestDataConfiguration {

  private final LaraPort laraPort;

  @PostConstruct
  public void setupData() {
    Room room = new Room();
    room.setName("Main room");
    room.setType(RoomType.BEDROOM);
    room.setId(UUID.fromString("7d75a285-526a-4359-9c74-ed55928708fa"));
    laraPort.createRoom(room);

    Feature temperature = new Feature();
    temperature.setId(UUID.fromString("fec30aec-9e15-402f-a4e4-10e99cd73804"));
    temperature.setName("Temperature");
    temperature.setType(FeatureType.TEMPERATURE);
    laraPort.createFeature(room.getId(), temperature);

    Feature humidity = new Feature();
    humidity.setId(UUID.fromString("8520bedc-078b-49fd-b6fd-75a0e83c3bc7"));
    humidity.setName("Humidity");
    humidity.setType(FeatureType.HUMIDITY);
    laraPort.createFeature(room.getId(), humidity);
  }
}
