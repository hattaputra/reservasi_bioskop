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

import java.security.PublicKey;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {
    @Autowired
    TicketsServiceImpl ticketsServiceImpl;
    SeatsServiceImpl seatsServiceImpl;

    @PostMapping("/buy-ticket")
    public ResponseEntity<ResponseData<TicketData>> create(@RequestBody TicketsEntity ticket){
        try{
            TicketData tdata = new TicketData();
            ResponseData<TicketData> data = new ResponseData<>();
            UsersEntity user = ticket.getUsersEntity();
            SchedulesEntity schedules = ticket.getSchedulesEntity();
            FilmsEntity film = ticket.getSchedulesEntity().getFilmsEntity();
            SeatsEntity seat = ticket.getSeatsEntity();
            StudiosEntity studio = ticket.getSeatsEntity().getStudiosEntity();
            seat.setSeat_status(true);
            seatsServiceImpl.update(seat.getId(),seat);
            tdata.setUsername(user.getUsername());
            tdata.setFilm(film.getFilm_name());
            tdata.setPrice(schedules.getPrice());
            tdata.setStudio(studio.getStudio_name());
            tdata.setSeat(seat.getId());
            tdata.setShowDate(schedules.getShow_date());
            tdata.setStartAt(schedules.getStart_at());
            tdata.setEndAt(schedules.getEnd_at());
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
    public ResponseEntity<ResponseData<TicketsEntity>> update(@PathVariable Integer id, @RequestBody TicketsEntity ticket){
        try{
            ResponseData<TicketsEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("Ticket successfully updated");
            data.setData(ticketsServiceImpl.update(id, ticket));
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
