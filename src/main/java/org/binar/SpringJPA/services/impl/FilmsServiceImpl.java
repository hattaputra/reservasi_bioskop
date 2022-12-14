package org.binar.SpringJPA.services.impl;

import org.binar.SpringJPA.entities.FilmsEntity;
import org.binar.SpringJPA.repositories.FilmsRepo;
import org.binar.SpringJPA.services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmsServiceImpl implements FilmsService {
    @Autowired
    FilmsRepo filmsRepo;

    public FilmsEntity create(FilmsEntity film){
        return filmsRepo.save(film);
    }
    public FilmsEntity update(String code, FilmsEntity film){
        FilmsEntity data = filmsRepo.findById(code).get();
        data.setFilmName(film.getFilmName());
        data.setCategory(film.getCategory());
        data.setOnShow(film.getOnShow());
        return filmsRepo.save(data);
    }
    public FilmsEntity findOne(String code){
        Optional<FilmsEntity> film= filmsRepo.findById(code);
        if (!film.isPresent()){
            return null;
        }
        return film.get();
    }
    public Iterable<FilmsEntity> findAll(){
        return filmsRepo.findAll();
    }

    public List<FilmsEntity> isShowing(){
        return filmsRepo.findOnShowingFilms();
    }
    public void delete(String code){
        filmsRepo.deleteById(code);
    }
}
