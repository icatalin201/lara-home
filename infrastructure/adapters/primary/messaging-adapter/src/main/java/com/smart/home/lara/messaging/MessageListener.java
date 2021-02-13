package com.smart.home.lara.messaging;

import com.smart.home.lara.core.application.port.primary.FeatureDataPort;
import com.smart.home.lara.messaging.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static com.smart.home.lara.messaging.config.RabbitConfig.LARA_QUEUE;

/** lara Created by Catalin on 2/13/2021 */
@RequiredArgsConstructor
public class MessageListener {

  private final FeatureDataPort featureDataPort;

  @RabbitListener(queues = LARA_QUEUE)
  public void handleMessage(MessageDto messageDto) {
    featureDataPort.add(
        messageDto.getFeatureId(),
        messageDto.getValue(),
        getLocalDateTimeFromTimestamp(messageDto.getRecordedTimestamp()));
  }

  private LocalDateTime getLocalDateTimeFromTimestamp(Long timestamp) {
    return LocalDateTime.ofInstant(
        Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
  }
}
