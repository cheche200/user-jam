package com.jammify.userjammify.repository;

import com.jammify.userjammify.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
