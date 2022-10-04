package org.binar.SpringJPA.repositories;

import java.util.List;

import org.binar.SpringJPA.entities.SeatId;
import org.binar.SpringJPA.entities.SeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepo extends JpaRepository<SeatsEntity, SeatId> {
    List<SeatsEntity> findByStudioId(Integer id);
}
