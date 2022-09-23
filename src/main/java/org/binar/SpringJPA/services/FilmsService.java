package org.binar.SpringJPA.services;

import org.binar.SpringJPA.entities.FilmsEntity;


public interface FilmsService {
    public FilmsEntity create(FilmsEntity film);
    public FilmsEntity update(String film_code, FilmsEntity film);
    public FilmsEntity findOne(String code);
    public Iterable<FilmsEntity> findAll();
    public void delete(String code);
}
