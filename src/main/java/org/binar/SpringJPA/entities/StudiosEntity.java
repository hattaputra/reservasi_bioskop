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

    @MapsId("seatId")
    @JoinColumns({
            @JoinColumn(name = "seat_number", referencedColumnName = "seat_number"),
            @JoinColumn(name = "seat_row", referencedColumnName = "seat_row")
    })
    @ManyToOne
    private SeatsEntity seatsEntity;

    @Column(name = "studio_name")
    private String studio_name;

}
