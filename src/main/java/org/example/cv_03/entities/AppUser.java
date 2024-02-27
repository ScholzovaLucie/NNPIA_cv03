package org.example.cv_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name="appuser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column
    public String username;

    @Column
    public String password;

    @Column
    public boolean active;

    @Column
    public Date creation_date;

    @Column
    public Date update_date;

    @OneToMany(mappedBy = "author")
    private List<Task> tasks= Collections.emptyList();

    private Role

    public AppUser() {

    }

}
