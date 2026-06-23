package com.lughtech.rest;


import com.lughtech.rest.dto.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {

	@LocalServerPort
	private int port;

	private RestTestClient client;

	@BeforeEach
	public void setup() {
		client = RestTestClient.bindToServer()
				.baseUrl("http://localhost:" + port)
				.build();
	}

	@Test
	void shouldReturnUser() {
		client.get()
				.uri("/users/1")
				.exchange()
				.expectStatus().isOk()
				.expectBody(User.class);
	}

}
