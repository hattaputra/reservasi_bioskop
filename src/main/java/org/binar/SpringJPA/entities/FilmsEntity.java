package org.binar.SpringJPA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "films")
public class FilmsEntity {
    @Id
    @Column(name = "film_code")
    private String film_code;

    @Column(name = "film_name")
    private String film_name;

    @Column(name = "category")
    private String category;

    @Column(name = "onShow")
    private LocalDate onShow;
}
