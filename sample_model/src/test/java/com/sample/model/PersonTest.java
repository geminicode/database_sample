package com.sample.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonTest {

	@Test
	void testNotNull() {
		Person p = getPerson();
		assertNotNull(p);
		assertNotNull(p.getId());
		assertTrue(true);
	}

	private Person getPerson() {
		Person p = Person.builder()
				.id(UUID.randomUUID())
				.firstName("Test")
				.lastName("User")
				.build();
		log.info("Buidling user");
		return p;
	}
}
