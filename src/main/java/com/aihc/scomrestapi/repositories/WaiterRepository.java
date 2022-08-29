package com.aihc.scomrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aihc.scomrestapi.models.Waiter;

public interface WaiterRepository extends JpaRepository<Waiter, Integer> {
  
}
