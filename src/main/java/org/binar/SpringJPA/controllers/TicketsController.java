package org.binar.SpringJPA.controllers;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.entities.TicketsEntity;
import org.binar.SpringJPA.services.impl.TicketsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    TicketsServiceImpl ticketsServiceImpl;

//    @PostMapping("/create")
//    public ResponseEntity<ResponseData<TicketsEntity>> create(@RequestBody TicketsEntity ticket){
//        try{
//            ResponseData<TicketsEntity> data = new ResponseData<>();
//            data.setStatus("200");
//            data.setMessagge("Film successfully added");
//            ticketsServiceImpl.create(ticket);
//            data.setData(ticketsServiceImpl.create(ticket));
//            return ResponseEntity.ok(data);
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }

    @PostMapping("/create")
    public ResponseEntity<ResponseData<TicketsEntity>> create(@RequestBody TicketsEntity ticket){
        try{
            ResponseData<TicketsEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("Film successfully added");
            ticketsServiceImpl.create(ticket);
            data.setData(ticketsServiceImpl.create(ticket));
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
            data.setMessagge("Film successfully added");
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
