package org.example.cv_03.controllers;

import lombok.RequiredArgsConstructor;
import org.example.cv_03.entities.Person;
import org.example.cv_03.repository.PersonRepository;
import org.example.cv_03.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonRepository repository;

    public static final String APP_USER_PATH = "/app-user/v1";

    @GetMapping(value = APP_USER_PATH + "/{id}")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Person getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);

        return Optional.of(person).orElseThrow(null);
    }

    @DeleteMapping(APP_USER_PATH + "/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {

        Person person = personService.getPersonById(id);
        if (person != null) {
            repository.delete(person);
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return ResponseEntity.notFound().build();
    }


}