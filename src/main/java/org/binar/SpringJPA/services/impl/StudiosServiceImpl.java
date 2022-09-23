package org.binar.SpringJPA.services.impl;

import org.binar.SpringJPA.entities.StudiosEntity;
import org.binar.SpringJPA.entities.UsersEntity;
import org.binar.SpringJPA.repositories.StudiosRepo;
import org.binar.SpringJPA.services.StudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudiosServiceImpl implements StudiosService {
    @Autowired
    StudiosRepo studiosRepo;

    public StudiosEntity create(StudiosEntity studio){
        return studiosRepo.save(studio);
    }
    public StudiosEntity update(Integer id, StudiosEntity studiosEntity){
        StudiosEntity data = studiosRepo.findById(id).get();
        data.getStudio_name();
        return studiosRepo.save(data);
    }
    public StudiosEntity findOne(Integer id){
        Optional<StudiosEntity> studio = studiosRepo.findById(id);
        if (!studio.isPresent()){
            return null;
        }
        return studio.get();
    }
    public Iterable<StudiosEntity> findAll(){
        return studiosRepo.findAll();
    }
    public void delete(Integer id){
        studiosRepo.deleteById(id);
    }
}
