package org.binar.SpringJPA.controllers;

import org.binar.SpringJPA.dto.ResponseData;
import org.binar.SpringJPA.entities.UsersEntity;
import org.binar.SpringJPA.services.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersServiceImpl usersServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ResponseData> create(@RequestBody UsersEntity user){
        try{
            ResponseData data = new ResponseData();
            data.setStatus("200");
            data.setMessagge("User successfully created");
            data.setData(usersServiceImpl.create(user));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/update/{username}")
    public ResponseEntity<ResponseData> update(@PathVariable String username, @RequestBody UsersEntity user){
        try{
            ResponseData data = new ResponseData();
            data.setStatus("200");
            data.setMessagge("User successfully updated");
            usersServiceImpl.update(username, user);
            data.setData(usersServiceImpl.findById(username));
            return ResponseEntity.ok(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
//    public UsersEntity update(@PathVariable String username, @RequestBody UsersEntity user){
//        return  usersServiceImpl.update(username, user);
//    }
    @GetMapping("/get-all")
    public Iterable<UsersEntity> findAll(){
        return usersServiceImpl.findAll();
    }
    @GetMapping("/get-one/{username}")
    public UsersEntity findOne(@PathVariable String username){
        return usersServiceImpl.findById(username);
    }
    @DeleteMapping("/drop/{username}")
    public void delete(@PathVariable String username){
        usersServiceImpl.delete(username);
    }
}
