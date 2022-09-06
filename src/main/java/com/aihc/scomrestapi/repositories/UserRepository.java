package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUsernameOrEmail(String username, String email);
}
