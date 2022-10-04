package org.binar.SpringJPA.services.impl;

import org.binar.SpringJPA.entities.SeatId;
import org.binar.SpringJPA.entities.SeatsEntity;
import org.binar.SpringJPA.repositories.SeatsRepo;
import org.binar.SpringJPA.services.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatsServiceImpl implements SeatsService {
    @Autowired
    SeatsRepo seatsRepo;

    public SeatsEntity create(SeatsEntity seat){
        seat.setSeatStatus(true);
        return  seatsRepo.save(seat);
    }
    public SeatsEntity update(SeatId id, SeatsEntity seat){
        SeatsEntity data = seatsRepo.findById(id).get();
        data.setSeatStatus(seat.isSeatStatus());
        return  seatsRepo.save(data);
    }
    public SeatsEntity findOne(SeatId id){
        Optional<SeatsEntity> seat = seatsRepo.findById(id);
        if (!seat.isPresent()){
            return null;
        }
        return seat.get();
    }
    public List<SeatsEntity> findByStudioId(Integer id){
        return seatsRepo.findByStudioId(id);
    }
    public Iterable<SeatsEntity> findAll(){
        return seatsRepo.findAll();
    }
    public void delete(SeatId id){
        seatsRepo.deleteById(id);
    }
}