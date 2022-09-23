package org.binar.SpringJPA.controllers;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.entities.SchedulesEntity;
import org.binar.SpringJPA.services.impl.SchedulesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class SchedulesController {
    @Autowired
    SchedulesServiceImpl schedulesServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ResponseData<SchedulesEntity>> create(@RequestBody SchedulesEntity schedule){
        try{
            ResponseData<SchedulesEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("User successfully created");
            data.setData(schedulesServiceImpl.create(schedule));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-all")
    public Iterable<SchedulesEntity> findAll(){
        return schedulesServiceImpl.findAll();
    }

    @GetMapping("/get-one/{id}")
    public SchedulesEntity findOne(@PathVariable Integer id){
        return schedulesServiceImpl.findOne(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseData<SchedulesEntity>> update(@PathVariable Integer id, @RequestBody SchedulesEntity schedule){
        try{
            ResponseData<SchedulesEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("User successfully created");
            data.setData(schedulesServiceImpl.update(id, schedule));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @DeleteMapping("/drop/{id}")
    public void delete(@PathVariable Integer id){
        schedulesServiceImpl.delete(id);
    }
}
