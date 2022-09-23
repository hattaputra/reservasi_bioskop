package org.binar.SpringJPA.services.impl;

import org.binar.SpringJPA.entities.SeatId;
import org.binar.SpringJPA.entities.SeatsEntity;
import org.binar.SpringJPA.repositories.SeatsRepo;
import org.binar.SpringJPA.services.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatsServiceImpl implements SeatsService {
    @Autowired
    SeatsRepo seatsRepo;

    public SeatsEntity create(SeatsEntity seat){
        return  seatsRepo.save(seat);
    }
    public SeatsEntity update(Character row, Integer number, SeatsEntity seat){
        SeatsEntity data = new SeatsEntity();
        data.setSeat_status(seat.isSeat_status());
        return  seatsRepo.save(data);
    }
    public SeatsEntity findOne(Character row, Integer number){
        Optional<SeatsEntity> seat = seatsRepo.findById(new SeatId(row, number));
        if (!seat.isPresent()){
            return null;
        }
        return seat.get();
    }
    public Iterable<SeatsEntity> findAll(){
        return seatsRepo.findAll();
    }
    public void delete(Character row, Integer number){
        seatsRepo.deleteById(new SeatId(row, number));
    }
}