package com.vasvince.repositories;

import com.vasvince.entities.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<MyUser, Integer> {

}
