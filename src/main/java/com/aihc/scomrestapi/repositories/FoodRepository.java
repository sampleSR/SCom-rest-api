package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {}
