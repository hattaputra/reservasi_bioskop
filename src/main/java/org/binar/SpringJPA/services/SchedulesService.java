package org.binar.SpringJPA.services;

import org.binar.SpringJPA.entities.SchedulesEntity;

public interface SchedulesService {
    public SchedulesEntity create(SchedulesEntity schedule);
    public SchedulesEntity update(Integer id,SchedulesEntity schedule);
    public SchedulesEntity findOne(Integer id);
    public SchedulesEntity findByCode(String code);
    public Iterable<SchedulesEntity> findAll();
    public void delete(Integer id);
}
