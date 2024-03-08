package org.example.cv_03.repository;

import org.example.cv_03.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
