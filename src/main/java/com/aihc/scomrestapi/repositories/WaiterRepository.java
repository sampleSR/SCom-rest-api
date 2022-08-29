package com.aihc.scomrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aihc.scomrestapi.models.Waiter;
@Repository
public interface WaiterRepository extends JpaRepository<Waiter, Integer> {
  
}
