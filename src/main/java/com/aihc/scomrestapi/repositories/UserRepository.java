package com.aihc.scomrestapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aihc.scomrestapi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
  
  public Optional<User> findByUsernameOrEmail(String username, String email);

}
