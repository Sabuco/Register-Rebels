package com.concatel.restful;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import com.concatel.restful.controllers.RebelController;
import com.concatel.restful.exceptions.InvalidRebelException;
import com.concatel.restful.models.Rebel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

@SpringBootTest
class RegisterSpringbootApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAllRebel() throws RestClientException, InvalidRebelException {
		assertTrue(
                this.restTemplate.getForObject("http://localhost:" + port + "/rebel", RebelController.class)
                    .getAllRebel().size() > 0);
	}

	@Test
    public void testAddRebel() {
        Rebel rebel = new Rebel(1, "Alvaro", "Tierra", LocalDate.now());
        ResponseEntity<String> responseEntity = this.restTemplate
            .postForEntity("http://localhost:" + port + "/rebel", rebel, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
	}
	

}
