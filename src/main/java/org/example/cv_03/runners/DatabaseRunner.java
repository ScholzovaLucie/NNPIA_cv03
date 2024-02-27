package org.example.cv_03.runners;

import org.example.cv_03.entities.AppUser;
import org.example.cv_03.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseRunner implements CommandLineRunner {

    private final AppUserRepository appUserRepository;

    public DatabaseRunner(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser user1 = new AppUser();
        user1.setUsername("admin");
        user1.setPassword("admin");
        user1.setActive(true);

        appUserRepository.save(user1);

    }


}
