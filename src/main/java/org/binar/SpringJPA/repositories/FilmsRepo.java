package org.binar.SpringJPA.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.binar.SpringJPA.entities.FilmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmsRepo extends JpaRepository<FilmsEntity, String> {

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Query("SELECT f FROM FilmsEntity f WHERE f.onShow = :date")
    List<FilmsEntity> findOnShowingFilms(@PathParam("date") LocalDate date);
}
