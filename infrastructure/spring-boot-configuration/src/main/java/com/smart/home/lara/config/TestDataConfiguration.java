package com.smart.home.lara.config;

import com.smart.home.lara.core.application.port.primary.FeaturePort;
import com.smart.home.lara.core.application.port.primary.RoomPort;
import com.smart.home.lara.core.domain.model.Feature;
import com.smart.home.lara.core.domain.model.FeatureType;
import com.smart.home.lara.core.domain.model.Room;
import com.smart.home.lara.core.domain.model.RoomType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

/** lara Created by Catalin on 2/14/2021 */
@Configuration
@RequiredArgsConstructor
public class TestDataConfiguration {

  private final RoomPort roomPort;
  private final FeaturePort featurePort;

  @PostConstruct
  public void setupData() {
    Room room = new Room();
    room.setName("Main room");
    room.setType(RoomType.BEDROOM);
    room.setId(UUID.fromString("7d75a285-526a-4359-9c74-ed55928708fa"));
    roomPort.create(room);

    Feature temperature = new Feature();
    temperature.setId(UUID.fromString("fec30aec-9e15-402f-a4e4-10e99cd73804"));
    temperature.setName("Temperature");
    temperature.setType(FeatureType.TEMPERATURE);
    featurePort.create(room.getId(), temperature);

    Feature humidity = new Feature();
    humidity.setId(UUID.fromString("8520bedc-078b-49fd-b6fd-75a0e83c3bc7"));
    humidity.setName("Humidity");
    humidity.setType(FeatureType.HUMIDITY);
    featurePort.create(room.getId(), humidity);
  }
}
