package org.binar.SpringJPA.services;

import org.binar.SpringJPA.entities.TicketsEntity;

public interface TicketsService {
    public TicketsEntity create(TicketsEntity ticket);
    public TicketsEntity update(Integer id,TicketsEntity ticket);
    public TicketsEntity findOne(Integer id);
    public Iterable<TicketsEntity> findAll();
    public void delete(Integer id);
}
