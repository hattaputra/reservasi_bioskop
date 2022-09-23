package org.binar.SpringJPA.services;

import org.binar.SpringJPA.entities.UsersEntity;

public interface UsersService {
    public UsersEntity create(UsersEntity user);

    public UsersEntity update(String username, UsersEntity usersEntity);
    public UsersEntity findById(String username);
    public Iterable<UsersEntity> findAll();
    public void delete(String username);
}
