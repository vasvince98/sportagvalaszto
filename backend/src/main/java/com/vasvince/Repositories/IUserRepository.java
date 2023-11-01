package com.vasvince.Repositories;

import com.vasvince.Entities.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<MyUser, Integer> {

}
