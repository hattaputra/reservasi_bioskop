package org.binar.SpringJPA.services.impl;

import org.binar.SpringJPA.entities.UsersEntity;
import org.binar.SpringJPA.repositories.UsersRepo;
import org.binar.SpringJPA.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepo usersRepo;

    public UsersEntity create(UsersEntity user){
        return usersRepo.save(user);
    }
    public UsersEntity update(String username, UsersEntity usersEntity){
        UsersEntity user = usersRepo.findById(username).get();
        user.setEmail(usersEntity.getEmail());
        user.setPassword(usersEntity.getPassword());
        return usersRepo.save(user);
    }
    public UsersEntity findById(String username){
        Optional<UsersEntity> user = usersRepo.findById(username);
        if(!user.isPresent()){
            return null;
        }
        return user.get();
    }
    public Iterable<UsersEntity> findAll(){
        return usersRepo.findAll();
    }
    public void delete(String username){
        usersRepo.deleteById(username);
    }
}
