package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaiterRepository extends JpaRepository<Waiter, Integer> {}
