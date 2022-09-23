package org.binar.SpringJPA.repositories;

import org.binar.SpringJPA.entities.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepo extends JpaRepository<TicketsEntity, Integer> {

}
