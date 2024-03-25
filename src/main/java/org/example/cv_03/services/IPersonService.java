package org.example.cv_03.services;

import org.example.cv_03.entities.Person;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface IPersonService {
    Person getPersonById(Long id);

    void deletePersonById(Long id);

    public List<Person> listPersons();
}
