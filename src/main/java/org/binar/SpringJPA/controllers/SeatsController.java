package org.binar.SpringJPA.controllers;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.entities.SeatId;
import org.binar.SpringJPA.entities.SeatsEntity;
import org.binar.SpringJPA.entities.UsersEntity;
import org.binar.SpringJPA.services.impl.SeatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seats")
public class SeatsController {
    @Autowired
    SeatsServiceImpl seatsServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ResponseData<SeatsEntity>> create(@RequestBody SeatsEntity seat){
        try{
            ResponseData<SeatsEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("Seat successfully created");
            data.setData(seatsServiceImpl.create(seat));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-all")
    public Iterable<SeatsEntity> findAll(){
        return seatsServiceImpl.findAll();
    }

    @GetMapping("/get-one/{row}/{number}")
    public SeatsEntity findOne(@PathVariable Character row, @PathVariable Integer number){
        return seatsServiceImpl.findOne(new SeatId(row, number));
    }

    @PutMapping("/update/{row}/{number}")
    public ResponseEntity<ResponseData<SeatsEntity>> update(@PathVariable Character row, @PathVariable Integer number, @RequestBody SeatsEntity seat){
        try{
            ResponseData<SeatsEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("Seat successfully updated");
            data.setData(seatsServiceImpl.update(new SeatId(row, number), seat));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
