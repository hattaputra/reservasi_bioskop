package org.binar.SpringJPA.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "show_date")
    private LocalDate show_date;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "start_at")
    private LocalTime start_at;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "end_at")
    private LocalTime end_at;
}
