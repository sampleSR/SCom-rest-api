package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Integer> {}
