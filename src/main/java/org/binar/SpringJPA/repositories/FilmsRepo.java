package org.binar.SpringJPA.repositories;

import org.binar.SpringJPA.entities.FilmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepo extends JpaRepository<FilmsEntity, String> {

}
