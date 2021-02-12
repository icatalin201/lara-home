package com.smart.home.lara.repo.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
@EnableR2dbcRepositories
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {

  @Override
  public ConnectionFactory connectionFactory() {
    H2ConnectionFactory.inMemory("");
    return null;
  }
}
