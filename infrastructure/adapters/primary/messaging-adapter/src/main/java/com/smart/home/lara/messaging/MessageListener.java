package com.smart.home.lara.messaging;

import com.smart.home.lara.core.application.port.primary.FeatureDataPort;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/** lara Created by Catalin on 2/13/2021 */
@RequiredArgsConstructor
public class MessageListener {

  private final FeatureDataPort featureDataPort;

  @RabbitListener
  public void handleMessage() {}
}
