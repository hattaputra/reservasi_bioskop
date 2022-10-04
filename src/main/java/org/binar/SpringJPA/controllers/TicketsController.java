package org.binar.SpringJPA.controllers;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.dto.TicketData;
import org.binar.SpringJPA.entities.*;
import org.binar.SpringJPA.services.impl.SeatsServiceImpl;
import org.binar.SpringJPA.services.impl.TicketsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tickets")
public class TicketsController {
    @Autowired
    TicketsServiceImpl ticketsServiceImpl;
    SeatsServiceImpl seatsServiceImpl;

    @PostMapping("/buy-ticket")
    public ResponseEntity<ResponseData> create(@RequestBody TicketsEntity ticket){
        try{
            TicketData tdata = new TicketData();
            ResponseData data = new ResponseData();
            UsersEntity user = ticket.getUsersEntity();
            SchedulesEntity schedules = ticket.getSchedulesEntity();
            FilmsEntity film = ticket.getSchedulesEntity().getFilmsEntity();
            SeatsEntity seat = ticket.getSeatsEntity();
            StudiosEntity studio = ticket.getSeatsEntity().getStudiosEntity();
            seat.setSeatStatus(true);
            seatsServiceImpl.update(seat.getSeatId(),seat);
            tdata.setUsername(user.getUsername());
            tdata.setFilm(film.getFilmName());
            tdata.setPrice(schedules.getPrice());
            tdata.setStudio(studio.getStudioName());
            tdata.setSeat(seat.getSeatId());
            tdata.setShowDate(schedules.getShowDate());
            tdata.setStartAt(schedules.getStartAt());
            tdata.setEndAt(schedules.getEndAt());
            data.setStatus("200");
            data.setMessagge("Ticket successfully reserved");
            data.setData(tdata);
            ticketsServiceImpl.create(ticket);
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseData> update(@PathVariable Integer id, @RequestBody TicketsEntity ticket){
        try{
            ResponseData data = new ResponseData();
            data.setStatus("200");
            data.setMessagge("Ticket successfully updated");
            ticketsServiceImpl.update(id, ticket);
            data.setData(ticketsServiceImpl.findOne(id));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-all")
    public Iterable<TicketsEntity> findAll(){
        return ticketsServiceImpl.findAll();
    }
    @GetMapping("/get-one/{id}")
    public TicketsEntity findOne(@PathVariable Integer id){
        return ticketsServiceImpl.findOne(id);
    }
    @DeleteMapping("/drop/{id}")
    public void delete(@PathVariable Integer id){
        ticketsServiceImpl.delete(id);
    }
}
