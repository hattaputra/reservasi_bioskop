package org.binar.SpringJPA.controllers;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.entities.FilmsEntity;
import org.binar.SpringJPA.services.impl.FilmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmsController {
    @Autowired
    FilmsServiceImpl filmsServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ResponseData<FilmsEntity>> create(@RequestBody FilmsEntity film){
        try{
            ResponseData<FilmsEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("Film successfully added");
            data.setData(filmsServiceImpl.create(film));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseData<FilmsEntity>> update(@PathVariable String id, @RequestBody FilmsEntity film){
        try{
            ResponseData<FilmsEntity> data = new ResponseData<>();
            data.setStatus("200");
            data.setMessagge("Film successfully added");
            data.setData(filmsServiceImpl.update(id, film));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-all")
    public Iterable<FilmsEntity> findAll(){
        return filmsServiceImpl.findAll();
    }
    @GetMapping("/get-one/{id}")
    public FilmsEntity findOne(@PathVariable String id){
        return filmsServiceImpl.findOne(id);
    }
    @GetMapping("/get-showing")
    public List<FilmsEntity> isShowing(){
        return filmsServiceImpl.isShowing();
    }
    @DeleteMapping("/drop/{id}")
    public void delete(@PathVariable String id){
        filmsServiceImpl.delete(id);
    }
}
