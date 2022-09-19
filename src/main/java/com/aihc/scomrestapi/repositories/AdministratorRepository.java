package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {}
