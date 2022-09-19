package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {}
