package com.vasvince.repositories;

import com.vasvince.entities.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICardRepository extends CrudRepository<Card, Integer> {
    List<Card> findAll();
}
