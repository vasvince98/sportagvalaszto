package com.vasvince.Repositories;

import com.vasvince.Entities.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends CrudRepository<Card, Integer> {

}
