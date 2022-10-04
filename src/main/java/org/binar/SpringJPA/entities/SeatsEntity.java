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
@Table(name = "seats")
public class SeatsEntity {

    @EmbeddedId
    private SeatId seatId;

    @Column(name = "studio_id")
    private Integer studioId;

    @ManyToOne
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id", insertable = false, updatable = false)
    private StudiosEntity studiosEntity;

    @Column(name = "seat_status")
    private boolean seatStatus;
}
