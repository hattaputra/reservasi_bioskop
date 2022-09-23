package org.binar.SpringJPA.dto;

import lombok.Getter;
import lombok.Setter;
import org.binar.SpringJPA.entities.SeatId;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TicketData {
    private String username;
    private String film;
    private int price;
    private String studio;
    private SeatId seat;
    private LocalDate showDate;
    private LocalTime startAt;
    private LocalTime endAt;
}
