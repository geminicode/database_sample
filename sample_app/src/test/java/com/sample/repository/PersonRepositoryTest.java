package com.sample.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sample.model.Person;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class PersonRepositoryTest {

	
	
	@Autowired
	PersonRepository repository;
	
	@Test
	void testNotNull() {
		Person p = getPerson();
		assertNotNull(p);
		assertNotNull(p.getId());
		log.info("done");
	}

	@Test
	void testCreate() {
		Person p = getPerson();
		Person saved = repository.save(p);
		assertEquals(p.getId(), saved.getId());
		assertThat(saved.getCreatedOn()).isNotNull();
		log.info("done");
	}
	
	private Person getPerson() {
		Person p = Person.builder()
				.id(UUID.randomUUID())
				.firstName("Test")
				.lastName("User")
				.build();
		log.info("getPerson");
		
		return p;
	}
}
