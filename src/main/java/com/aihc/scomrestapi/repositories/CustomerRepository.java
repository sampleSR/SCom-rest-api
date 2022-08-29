package com.aihc.scomrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aihc.scomrestapi.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
  
}
