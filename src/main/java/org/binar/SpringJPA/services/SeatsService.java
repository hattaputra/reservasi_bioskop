package org.binar.SpringJPA.services;

import java.util.List;

import org.binar.SpringJPA.entities.SeatId;
import org.binar.SpringJPA.entities.SeatsEntity;

public interface SeatsService {
    public SeatsEntity create(SeatsEntity seat);
    public SeatsEntity update(SeatId id, SeatsEntity seat);
    public SeatsEntity findOne(SeatId id);
    public List<SeatsEntity> findByStudioId(Integer id);
    public Iterable<SeatsEntity> findAll();
    public void delete(SeatId id);
}
