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
    private String title;

    @Column
    private String text;

    @Column
    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private Date creation_date;

    @Column(columnDefinition = "TIMESTAMP")
    private Date update_date;

}
