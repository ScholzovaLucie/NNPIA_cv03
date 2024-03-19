package org.example.cv_03.services;

import org.example.cv_03.entities.Person;

import java.util.Optional;

public interface PersonService {
    Person getPersonById(Long id);

    void deletePersonById(Long id);
}
