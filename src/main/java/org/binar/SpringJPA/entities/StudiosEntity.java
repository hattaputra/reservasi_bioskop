package org.binar.SpringJPA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "studios")
public class StudiosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private Integer studio_id;

    @Column(name = "studio_name")
    private String studio_name;

}
