package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Integer> {}
