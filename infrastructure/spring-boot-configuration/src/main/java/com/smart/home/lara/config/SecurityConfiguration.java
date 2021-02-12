package com.smart.home.lara.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/** lara Created by Catalin on 2/12/2021 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.csrf()
        .disable()
        .authorizeExchange()
        .pathMatchers("/api/v1/**")
        .permitAll()
        .anyExchange()
        .denyAll()
        .and()
        .oauth2ResourceServer()
        .jwt();
    return http.build();
  }
}
