package com.sample.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import com.sample.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, UUID> {

}
