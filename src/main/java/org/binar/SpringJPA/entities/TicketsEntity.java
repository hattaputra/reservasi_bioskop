package org.binar.SpringJPA.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class TicketsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticket_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UsersEntity usersEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")
    private SchedulesEntity schedulesEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private StudiosEntity studiosEntity;

    @Column(name ="studio_name")
    private String studioName;

    @Column(name ="seat_row")
    private Character seat_row;

    @Column(name ="seat_number")
    private Integer seat_number;

    @Column(name ="film_name")
    private String film;

    @Column(name ="price")
    private Integer price;

    @Column(name ="show_date")
    private LocalDate showdate;

    @Column(name ="start_at")
    private LocalTime start_at;

    @Column(name ="end_at")
    private LocalTime End_at;
}
