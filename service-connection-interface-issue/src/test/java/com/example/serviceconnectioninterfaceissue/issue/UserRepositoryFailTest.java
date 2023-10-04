package com.example.serviceconnectioninterfaceissue.issue;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class UserRepositoryFailTest implements PostgresContainerWithServiceConnection, WithAssertions {
  @Autowired
  private UserRepository sut;

  @Test
  void createUser() {
    assertThat(sut.save(UserEntity.builder().name("Billy Bob").build()))
        .isNotNull()
        .extracting(UserEntity::getName)
        .isEqualTo("Billy Bob");
  }
}