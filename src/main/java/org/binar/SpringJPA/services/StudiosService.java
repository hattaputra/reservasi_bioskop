package org.binar.SpringJPA.services;

import org.binar.SpringJPA.entities.StudiosEntity;

public interface StudiosService {
    public StudiosEntity create(StudiosEntity studio);
    public StudiosEntity update(Integer id, StudiosEntity studio);
    public StudiosEntity findOne(Integer id);
    public Iterable<StudiosEntity> findAll();
    public void delete(Integer id);
}
