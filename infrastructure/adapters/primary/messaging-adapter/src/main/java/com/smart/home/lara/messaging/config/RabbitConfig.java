package com.smart.home.lara.messaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** lara Created by Catalin on 2/13/2021 */
@Configuration
public class RabbitConfig {

  public static final String LARA_QUEUE = "Lara.Queue";
  private static final String TOPIC_EXCHANGE = "Lara.Topic";
  private static final String LARA_ROUTING_KEY = "Lara.Routing";

  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(TOPIC_EXCHANGE);
  }

  @Bean
  public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public Queue queue() {
    return new Queue(LARA_QUEUE);
  }

  @Bean
  public Binding binding(Queue queue, TopicExchange topicExchange) {
    return BindingBuilder.bind(queue).to(topicExchange).with(LARA_ROUTING_KEY);
  }
}
