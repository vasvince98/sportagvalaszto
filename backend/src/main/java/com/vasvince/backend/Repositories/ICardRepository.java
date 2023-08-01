package com.vasvince.backend.Repositories;

import com.vasvince.backend.Entities.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends CrudRepository<Card, Integer> {

}
