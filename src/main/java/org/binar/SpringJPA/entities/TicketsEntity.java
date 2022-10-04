package org.binar.SpringJPA.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")
public class TicketsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticket_id;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UsersEntity usersEntity;

    @Column(name = "schedule_id")
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", insertable = false, updatable = false)
    private SchedulesEntity schedulesEntity;

    @Column(name = "seat_number")
    private Integer seatNumber;
    @Column(name = "seat_row")
    private Character seatRow;

    @MapsId("seatId")
    @JoinColumns({
            @JoinColumn(name = "seat_number", referencedColumnName = "seat_number", insertable = false, updatable = false),
            @JoinColumn(name = "seat_row", referencedColumnName = "seat_row", insertable = false, updatable = false)
    })
    @OneToOne
    private SeatsEntity seatsEntity;

}
