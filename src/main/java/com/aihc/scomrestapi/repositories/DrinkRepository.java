package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {}
