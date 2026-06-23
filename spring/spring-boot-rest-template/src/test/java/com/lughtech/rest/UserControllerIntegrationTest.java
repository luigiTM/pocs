package com.lughtech.rest;


import com.lughtech.rest.dto.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.boot.resttestclient.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void shouldReturnUser() {
		ResponseEntity<User> response =
				restTemplate.getForEntity("/users", User.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
