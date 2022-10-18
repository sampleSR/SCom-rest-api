package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.FoodIngredient;
import com.aihc.scomrestapi.db.entities.keys.FoodIngredientKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodIngredientRepository
    extends JpaRepository<FoodIngredient, FoodIngredientKey> {}
