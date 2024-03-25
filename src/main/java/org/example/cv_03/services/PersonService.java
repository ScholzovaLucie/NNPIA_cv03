package org.example.cv_03.services;

import lombok.AllArgsConstructor;
import org.example.cv_03.entities.Person;
import org.example.cv_03.entities.Role;
import org.example.cv_03.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class PersonService implements IPersonService {

    List<Person> persons = new ArrayList<>();

    public PersonService(){
        Role role1 = new Role();
        role1.setName("udrzbar");
        Person user1 = new Person();
        user1.setUsername("Lukas");
        user1.setPassword("heslo");
        user1.setActive(true);
        Set<Role> user1_roles = new HashSet<>();
        user1_roles.add(role1);
        user1.setRoles(user1_roles);

        persons.add(user1);
    }

    public Person saveNewPerson(Person person){
        persons.add(person);
        return person;
    }


    @Override
    public Person getPersonById(Long id) {
        for (Person person: persons){
            if (Objects.equals(person.getId(), id)) return person;
        }
        return null;
    }

    @Override
    public void deletePersonById(Long id) {

    }

    @Override
    public List<Person> listPersons() {
        return persons;
    }
}
