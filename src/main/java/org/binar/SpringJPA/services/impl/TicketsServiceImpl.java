package org.binar.SpringJPA.services.impl;

import org.binar.SpringJPA.entities.TicketsEntity;
import org.binar.SpringJPA.repositories.TicketsRepo;
import org.binar.SpringJPA.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketsServiceImpl implements TicketsService {
    @Autowired
    TicketsRepo ticketsRepo;

    public TicketsEntity create(TicketsEntity ticket){
        return ticketsRepo.save(ticket);
    }
    public TicketsEntity update(Integer id, TicketsEntity ticket){
        TicketsEntity data = ticketsRepo.findById(id).get();
        return ticketsRepo.save(data);
    }
    public TicketsEntity findOne(Integer id){
        Optional<TicketsEntity> ticket = ticketsRepo.findById(id);
        if (!ticket.isPresent()){
            return null;
        }
        return ticket.get();
    }
    public Iterable<TicketsEntity> findAll(){
        return ticketsRepo.findAll();
    }
    public void delete(Integer id){
        ticketsRepo.deleteById(id);
    }
}
