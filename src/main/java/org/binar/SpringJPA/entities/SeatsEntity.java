package org.binar.SpringJPA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "seats")
public class SeatsEntity {

    @EmbeddedId
    private SeatId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private StudiosEntity studiosEntity;

    @Column(name = "seat_status")
    private boolean seat_status;
}
