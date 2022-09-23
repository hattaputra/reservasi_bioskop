package org.binar.SpringJPA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "schedules")
public class SchedulesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer schedule_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_code", referencedColumnName = "film_code")
    private FilmsEntity filmsEntity;

    @Column(name = "price")
    private Integer price;

    @Column(name = "show_date")
    private LocalDate show_date;

    @Column(name = "start_at")
    private LocalTime start_at;

    @Column(name = "end_at")
    private LocalTime end_at;
}
