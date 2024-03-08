package org.example.cv_03.services;

import lombok.AllArgsConstructor;
import org.example.cv_03.entities.Person;
import org.example.cv_03.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }
}