package org.binar.SpringJPA.controllers;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.entities.StudiosEntity;
import org.binar.SpringJPA.services.impl.StudiosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studios")
public class StudiosController {
    @Autowired
    StudiosServiceImpl studiosServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ResponseData> create(@RequestBody StudiosEntity studio){
        try{
            ResponseData data = new ResponseData();
            data.setStatus("200");
            data.setMessagge("Studio successfully added");
            data.setData(studiosServiceImpl.create(studio));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseData> update(@PathVariable Integer id, @RequestBody StudiosEntity studio){
        try{
            ResponseData data = new ResponseData();
            data.setStatus("200");
            data.setMessagge("Studio successfully added");
            studiosServiceImpl.update(id, studio);
            data.setData(studiosServiceImpl.findOne(id));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-all")
    public Iterable<StudiosEntity> findAll(){
        return studiosServiceImpl.findAll();
    }
    @GetMapping("/get-one/{id}")
    public StudiosEntity findOne(@PathVariable Integer id){
        return studiosServiceImpl.findOne(id);
    }
    @DeleteMapping("/drop/{id}")
    public void delete(@PathVariable Integer id){
        studiosServiceImpl.delete(id);
    }
}
