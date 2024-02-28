package org.example.cv_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    public String name;

    @OneToMany(mappedBy = "role")
    List<AppUserRole> app_user_roles =  Collections.emptyList();;

    public Role() {

    }


}
