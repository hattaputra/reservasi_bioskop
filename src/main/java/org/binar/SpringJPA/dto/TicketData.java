package org.binar.SpringJPA.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TicketData {
    private String username;
    private String film;
    private int price;
    private String studioName;
    private Character seatRow;
    private Integer seatNumber;
    private LocalDate showDate;
    private LocalTime startAt;
    private LocalTime endAt;
}
