package org.binar.SpringJPA.repositories;

import org.binar.SpringJPA.entities.StudiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudiosRepo extends JpaRepository<StudiosEntity, Integer> {

}
