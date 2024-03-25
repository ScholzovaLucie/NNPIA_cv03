package org.example.cv_03.repository;

import org.example.cv_03.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Override
    @Query("SELECT user FROM Person user WHERE user.active = true")
    public List<Person> findAll();

    @Query("SELECT user FROM Person user WHERE user.id = :id")
    public Person findAppUserById(@Param("id") Long id);


}
