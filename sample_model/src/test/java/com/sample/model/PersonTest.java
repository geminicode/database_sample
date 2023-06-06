package com.sample.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import com.sample.model.Person;

public class PersonTest {

	@Test
	void testNotNull() {
		Person p = getPerson();
		assertNotNull(p);
		assertNotNull(p.getId());
	}

	private Person getPerson() {
		Person p = Person.builder()
				.id(UUID.randomUUID())
				.firstName("Test")
				.lastName("User")
				.build();
		
		return p;
	}
}
