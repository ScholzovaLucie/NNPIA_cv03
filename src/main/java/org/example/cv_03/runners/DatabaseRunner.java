package org.example.cv_03.runners;

import org.example.cv_03.entities.AppUser;
import org.example.cv_03.entities.AppUserRole;
import org.example.cv_03.entities.Role;
import org.example.cv_03.entities.Task;
import org.example.cv_03.repository.AppUserRepository;
import org.example.cv_03.repository.AppUserRoleRepository;
import org.example.cv_03.repository.RoleRepository;
import org.example.cv_03.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



@Component
public class DatabaseRunner implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final AppUserRoleRepository appUserRoleRepository;
    private final RoleRepository roleRepository;
    private final TaskRepository taskRepository;

    public DatabaseRunner(AppUserRepository appUserRepository, AppUserRoleRepository appUserRoleRepository, RoleRepository roleRepository, TaskRepository taskRepository){
        this.appUserRepository = appUserRepository;
        this.appUserRoleRepository = appUserRoleRepository;
        this.roleRepository = roleRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser user1 = new AppUser();
        user1.setUsername("admin");
        user1.setPassword("admin");
        user1.setActive(true);

        Task task1 = new Task();
        task1.setTitle("title1");
        task1.setDescription("description1");
        task1.setAuthor(user1);

        Date date = new Date();
        task1.setCreation_date(date);
        task1.setUpdate_date(date);


        Role role1 = new Role();
        role1.setName("role1");

        AppUserRole appRole1 = new AppUserRole();
        appRole1.setApp_user(user1);
        appRole1.setRole(role1);
        List<AppUserRole> appRoles = new ArrayList<>();
        appRoles.add(appRole1);
        user1.setApp_user_roles(appRoles);


        appUserRepository.save(user1);
        taskRepository.save(task1);
        roleRepository.save(role1);
        appUserRoleRepository.save(appRole1);


    }


}
