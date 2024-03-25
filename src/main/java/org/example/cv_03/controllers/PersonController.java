package org.example.cv_03.controllers;

import lombok.RequiredArgsConstructor;
import org.example.cv_03.entities.Person;
import org.example.cv_03.repository.PersonRepository;
import org.example.cv_03.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    public PersonRepository repository;

    public static final String APP_USER_PATH = "/app-user/v1";

    @GetMapping(value = APP_USER_PATH + "/{id}")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Person getPersonById(@PathVariable Long id) {
        Person person = repository.findAppUserById(id);

        return Optional.of(person).orElseThrow(null);
    }

    @PutMapping(value = APP_USER_PATH + "/app-user-update")
    public ResponseEntity<?> updateExistingUser(@RequestParam Long id, @RequestBody Person person) {
        Person currentUser = repository.findAppUserById(id);
        currentUser.setUsername(person.getUsername());
        currentUser.setRoles(person.getRoles());
        currentUser.setUpdateDate(person.getUpdateDate());
        currentUser.setActive(person.isActive());
        currentUser.setPassword(person.getPassword());
        repository.save(currentUser);
        return ResponseEntity.ok().body("User updated");
    }

    @PostMapping(value = APP_USER_PATH + "/app-person-add")
    public ResponseEntity<?> addNewUser(@RequestBody Person person) {
        if (person != null) {
            repository.save(person);
            return ResponseEntity.ok().body("Sucessfully added new user");
        }
        if (repository.findAppUserById(person.getId()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        return ResponseEntity.badRequest().body("Problem somewhere in passed user");
    }

    @DeleteMapping(APP_USER_PATH + "/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {

        Person person = repository.findAppUserById(id);
        if (person != null) {
            repository.delete(person);
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return ResponseEntity.notFound().build();
    }


}