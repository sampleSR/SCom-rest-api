package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.User;
import com.aihc.scomrestapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}
