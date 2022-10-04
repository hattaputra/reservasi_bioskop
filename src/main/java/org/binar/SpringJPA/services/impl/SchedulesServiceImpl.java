package org.binar.SpringJPA.services.impl;

import org.binar.SpringJPA.entities.SchedulesEntity;
import org.binar.SpringJPA.repositories.SchedulesRepo;
import org.binar.SpringJPA.services.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulesServiceImpl implements SchedulesService {
    @Autowired
    SchedulesRepo schedulesRepo;

    public SchedulesEntity create(SchedulesEntity schedule){
        return schedulesRepo.save(schedule);
    }
    public SchedulesEntity update(Integer id, SchedulesEntity schedule){
        SchedulesEntity data = schedulesRepo.findById(id).get();
        data.getPrice();
        data.getShowDate();
        data.getStartAt();
        data.getEndAt();
        return schedulesRepo.save(data);
    }
    public SchedulesEntity findOne(Integer id){
        Optional<SchedulesEntity> schedule = schedulesRepo.findById(id);
        if(!schedule.isPresent()){
            return null;
        }
        return schedule.get();
    }
    public List<SchedulesEntity> findByCode(String code){
        return schedulesRepo.findByFilmCode(code);
    }
    public Iterable<SchedulesEntity> findAll(){
        return schedulesRepo.findAll();
    }
    public void delete(Integer id){
        schedulesRepo.deleteById(id);
    }
}
