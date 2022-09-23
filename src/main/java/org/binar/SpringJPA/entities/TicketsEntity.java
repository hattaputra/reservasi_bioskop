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

    @MapsId("seatId")
    @JoinColumns({
            @JoinColumn(name = "seat_number", referencedColumnName = "seat_number"),
            @JoinColumn(name = "seat_row", referencedColumnName = "seat_row")
    })
    @OneToOne
    private SeatsEntity seatsEntity;

}
