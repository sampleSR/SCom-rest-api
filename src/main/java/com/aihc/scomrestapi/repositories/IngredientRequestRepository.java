package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.IngredientRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRequestRepository extends JpaRepository<IngredientRequest, Integer>
{
}
