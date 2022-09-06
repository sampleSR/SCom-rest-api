package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {}
