package org.binar.SpringJPA.repositories;

import org.binar.SpringJPA.entities.FilmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmsRepo extends JpaRepository<FilmsEntity, String> {
    @Query("SELECT * FROM films WHERE films.onshow = ?1")
    List<FilmsEntity> findOnShowingFilms(LocalDate date);
}
