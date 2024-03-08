package org.example.cv_03.controllers;

import lombok.RequiredArgsConstructor;
import org.example.cv_03.entities.Person;
import org.example.cv_03.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    public static final String APP_USER_PATH = "/app-user/v1";

    @GetMapping(value = APP_USER_PATH + "/{id}")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Optional<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.getPersonById(id);

        return Optional.of(person).orElseThrow(null);
    }

    @DeleteMapping(APP_USER_PATH + "/{id}")
    public void deleteUserById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }


}