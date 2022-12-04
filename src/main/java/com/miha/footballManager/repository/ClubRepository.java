package com.miha.footballManager.repository;

import com.miha.footballManager.entity.Club;
import com.miha.footballManager.entity.Footballer;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends CrudRepository<Club,Integer> {
}
