package org.example.cv_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="TASKS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title = "title";

    @Column
    private String text = "text";

    @Column
    private String description = "description";

    @Column(columnDefinition = "TIMESTAMP")
    private Date creation_date = new Date();

    @Column(columnDefinition = "TIMESTAMP")
    private Date update_date = new Date();

    @ManyToOne
    @JoinColumn(name="person_id")
    public Person person;

}
