package org.binar.SpringJPA.services;

import org.binar.SpringJPA.entities.SeatsEntity;

public interface SeatsService {
    public SeatsEntity create(SeatsEntity seat);
    public SeatsEntity update(Character row, Integer number, SeatsEntity seat);
    public SeatsEntity findOne(Character row, Integer number);
    public Iterable<SeatsEntity> findAll();
    public void delete(Character row, Integer number);
}
