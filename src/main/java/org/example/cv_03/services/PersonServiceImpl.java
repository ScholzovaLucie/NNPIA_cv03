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
    public Person getPersonById(Long id) {
        return personRepository.findAppUserById(id);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}
