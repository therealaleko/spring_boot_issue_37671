package com.example.serviceconnectioninterfaceissue.issue;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public interface PostgresContainerWithDynamicPropertySource {
  @Container
  PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:11.1");

  @DynamicPropertySource
  static void initialize(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
    registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
  }
}
