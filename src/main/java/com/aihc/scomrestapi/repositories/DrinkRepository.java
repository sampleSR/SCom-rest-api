package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {}
