package com.miha.footballManager.repository;

import com.miha.footballManager.entity.Footballer;
import org.springframework.data.repository.CrudRepository;

public interface FootballerRepository extends CrudRepository<Footballer,Integer> {
}