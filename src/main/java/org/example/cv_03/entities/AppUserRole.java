package org.example.cv_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@Entity(name="appuserrole")
public class AppUserRole {

    @OneToMany
    @JoinColumn(name = "app_user_id", nullable = false)
    @ToString.Exclude
    public List<AppUser> app_user;

    @OneToMany
    @JoinColumn(name = "role_id", nullable = false)
    @ToString.Exclude
    public List<Role> role;

    public AppUserRole() {

    }
}
