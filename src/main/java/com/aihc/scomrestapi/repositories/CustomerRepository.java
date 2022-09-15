package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
