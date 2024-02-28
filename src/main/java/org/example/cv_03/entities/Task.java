package org.example.cv_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    public String title;

    @Column
    public String description;

    @Column
    public Date creation_date;

    @Column
    public Date update_date;

    @ManyToOne
    @JoinColumn(nullable = false, name = "author_id")
    AppUser author;

    public Task() {

    }
}
