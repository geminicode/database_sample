package com.sample.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sample.model.Person;

@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	PersonRepository repository;
	
	@Test
	void testNotNull() {
		Person p = getPerson();
		assertNotNull(p);
		assertNotNull(p.getId());
	}

	@Test
	void testCreate() {
		Person p = getPerson();
		Person saved = repository.save(p);
		assertEquals(p.getId(), saved.getId());
		assertThat(saved.getCreatedOn()).isNotNull();
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
