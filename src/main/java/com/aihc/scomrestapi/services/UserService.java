package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Bill;
import com.aihc.scomrestapi.db.entities.User;
import com.aihc.scomrestapi.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final AuthenticationService authenticationService;

  private final BillService billService;

  public UserService(
      final UserRepository userRepository,
      final AuthenticationService authenticationService,
      final BillService billService) {
    this.userRepository = userRepository;
    this.authenticationService = authenticationService;
    this.billService = billService;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public List<User> findAll() {
    List<User> users = userRepository.findAll();
    users.forEach(
        user -> {
          user.setRole(authenticationService.getRoleByUserId(user.getId()));
        });
    return users;
  }

  public User deleteById(final Integer id) {
    Optional<User> userWrapper = userRepository.findById(id);
    if (userWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    userRepository.delete(userWrapper.get());
    return userWrapper.get();
  }
}
