package org.example.cv_03.runners;

import org.example.cv_03.entities.Person;
import org.example.cv_03.entities.Role;
import org.example.cv_03.entities.Task;
import org.example.cv_03.repository.PersonRepository;
import org.example.cv_03.repository.RoleRepository;
import org.example.cv_03.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class DatabaseRunner implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final TaskRepository taskRepository;

    public DatabaseRunner(PersonRepository personRepository, RoleRepository roleRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Task task1 = new Task();
        task1.setTitle("Uklid");
        //task1.setAuthor(user1);
        Task task2 = new Task();
        task2.setTitle("odpocinek");
        //task2.setAuthor(user1);
        Task task3 = new Task();
        task3.setTitle("straz");
        //task3.setAuthor(user1);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);


        Role role1 = new Role();
        role1.setName("udrzbar");
        Role role2 = new Role();
        role2.setName("policista");
        Role role3 = new Role();
        role3.setName("reditel");
        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);


        Person user1 = new Person();
        user1.setUsername("Lukas");
        user1.setPassword("heslo");
        user1.setActive(true);
        Set<Role> user1_roles = new HashSet<>();
        user1_roles.add(role1);
        user1.setRoles(user1_roles);

        Person user2 = new Person();
        user2.setUsername("Eva");
        user2.setPassword("heslo");
        Set<Role> user2_roles = new HashSet<>();
        user2_roles.add(role2);
        user2_roles.add(role3);
        user1.setRoles(user2_roles);


        Person user3 = new Person();
        user3.setUsername("Matej");
        user3.setPassword("heslo");
        personRepository.save(user1);
        personRepository.save(user2);
        personRepository.save(user3);


    }


}
