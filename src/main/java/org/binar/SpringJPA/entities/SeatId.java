package org.binar.SpringJPA.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SeatId implements Serializable {
    @Column(name = "seat_row")
    private Character row;
    @Column(name = "seat_number")
    private Integer number;

    public SeatId(){}

    public SeatId(Character row, Integer number){
        this.row = row;
        this.number = number;
    }
}
