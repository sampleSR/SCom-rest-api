package com.aihc.scomrestapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aihc.scomrestapi.dtos.LoginRequestDTO;
import com.aihc.scomrestapi.dtos.LoginResponseDTO;
import com.aihc.scomrestapi.models.User;
import com.aihc.scomrestapi.repositories.UserRepository;

@Service
public class AuthenticationService {

  @Autowired
  UserRepository userRepository;
  
  public LoginResponseDTO authenticateUser(LoginRequestDTO request) {

    Optional<User> wrapperUser = userRepository.findByUsernameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail());

    LoginResponseDTO response = new LoginResponseDTO();
    response.setError("User or email wrong");
    response.setSuccess(false);
    response.setMessage("Bad credentials");
    
    User user = new User();
    if (wrapperUser.isPresent()) {
      user = wrapperUser.get();
    }
    if (user.getPassword().equals(request.getPassword())) {
      response.setError("");
      response.setData("token");
      response.setMessage("Ok");
      response.setSuccess(true);
    }
    return response;
  }  
}
