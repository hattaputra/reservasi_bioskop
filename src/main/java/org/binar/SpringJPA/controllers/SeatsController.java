package org.binar.SpringJPA.controllers;

import java.util.ArrayList;
import java.util.List;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.dto.SeatRes;
import org.binar.SpringJPA.entities.SeatId;
import org.binar.SpringJPA.entities.SeatsEntity;
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
    public ResponseEntity<ResponseData> create(@RequestBody SeatsEntity seat){
        try{
            ResponseData data = new ResponseData();
            SeatsEntity input = seatsServiceImpl.create(seat);
            SeatId id = input.getSeatId();
            SeatRes response = new SeatRes();
            response.setSeatNumber(id.getSeatNumber());
            response.setSeatRow(id.getSeatRow());
            response.setStudioId(input.getStudioId());
            response.setSeatStatus(input.isSeatStatus());
            data.setStatus("200");
            data.setMessagge("Seat successfully created");
            data.setData(response);
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

    @GetMapping("/get-seat-bystudio/{id}")
    public ResponseEntity<ResponseData> findByStudioId(@PathVariable Integer id){
        try{
            ResponseData data = new ResponseData();
            List<SeatRes> list = new ArrayList<>();
            List<SeatsEntity> input = seatsServiceImpl.findByStudioId(id);
            input.stream().map((x) -> {
                SeatRes response = new SeatRes();
                SeatId sid = x.getSeatId();
                response.setSeatNumber(sid.getSeatNumber());
                response.setSeatRow(sid.getSeatRow());
                response.setStudioId(x.getStudioId());
                response.setSeatStatus(x.isSeatStatus());
                return response;
            }).forEach((y) -> {
                list.add(y);
            });
            data.setStatus("200");
            data.setMessagge("Seat successfully retrieved");
            data.setData(list);
            return ResponseEntity.ok(data);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/update/{row}/{number}")
    public ResponseEntity<ResponseData> update(@PathVariable Character row, @PathVariable Integer number, @RequestBody SeatsEntity seat){
        try{
            ResponseData data = new ResponseData();
            seatsServiceImpl.update(new SeatId(row, number), seat);
            SeatsEntity input = seatsServiceImpl.findOne(new SeatId(row, number));
            SeatId id = input.getSeatId();
            SeatRes response = new SeatRes();
            response.setSeatNumber(id.getSeatNumber());
            response.setSeatRow(id.getSeatRow());
            response.setStudioId(input.getStudioId());
            response.setSeatStatus(input.isSeatStatus());
            data.setStatus("200");
            data.setMessagge("Seat successfully updated");
            data.setData(response);
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/drop/{row}/{number}")
    public void delete(@PathVariable Character row, @PathVariable Integer number){
        seatsServiceImpl.delete(new SeatId(row, number));
    }
}
