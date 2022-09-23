package org.binar.SpringJPA.repositories;


import org.binar.SpringJPA.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<UsersEntity, String> {

}
