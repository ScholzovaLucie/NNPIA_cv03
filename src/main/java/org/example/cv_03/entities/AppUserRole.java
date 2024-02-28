package org.example.cv_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@Entity(name="appuserrole")
public class AppUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user")
    @ToString.Exclude
    public AppUser app_user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "role_id")
    Role role;

    public AppUserRole() {

    }
}
