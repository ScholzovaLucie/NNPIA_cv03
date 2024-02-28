package org.example.cv_03.repository;

import org.example.cv_03.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.cv_03.entities.AppUser;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Override
    @Query("SELECT user FROM appuser user WHERE user.active = true")
    public List<AppUser> findAll();

    @Query("SELECT user FROM appuser user JOIN user.app_user_roles aur JOIN aur.role r WHERE r.name = :nameOfRole")
    public List<AppUser> findAllByRole(@Param("nameOfRole") String name);

}
