package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.db.entities.MissionVision;
import com.aihc.scomrestapi.db.entities.QuestionAnswer;
import com.aihc.scomrestapi.db.entities.User;
import com.aihc.scomrestapi.repositories.AdministratorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

  private final AdministratorRepository administratorRepository;
  private final AuthenticationService authenticationService;
  private final MissionVisionService missionVisionService;
  private final UserService userService;
  private final QuestionAnswerService   questionAnswerService;

  public AdministratorService(AdministratorRepository administratorRepository,
      AuthenticationService authenticationService, MissionVisionService missionVisionService,
      UserService userService, QuestionAnswerService questionAnswerService) {
    this.administratorRepository = administratorRepository;
    this.authenticationService = authenticationService;
    this.missionVisionService = missionVisionService;
    this.userService = userService;
    this.questionAnswerService = questionAnswerService;
  }

  public Administrator save(Administrator admin) {
    return administratorRepository.save(admin);
  }

  public Administrator findById(Integer id) {
    Optional<Administrator> adminWrapper = administratorRepository.findById(id);
    if (adminWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Administrator admin = adminWrapper.get();
    admin.setRole(authenticationService.getRoleByUserId(admin.getId()));
    return admin;
  }

  public Administrator update(final Integer id, final Administrator administrator) {
    Optional<Administrator> adminWrapper = administratorRepository.findById(id);
    if (adminWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    administrator.setId(id);
    administrator.setPassword(adminWrapper.get().getPassword());
    administrator.setRole(authenticationService.getRoleByUserId(id));
    return administratorRepository.save(administrator);
  }

  public Administrator deleteById(final Integer id) {
    Optional<Administrator> userWrapper = administratorRepository.findById(id);
    if (userWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    List<MissionVision> missionVisionList = missionVisionService.findByAdminId(id);
    missionVisionList.forEach(
        missionVision -> {
          missionVision.setAdministrator(null);
          missionVisionService.save(missionVision);
        });
    List<QuestionAnswer> questionAnswerList = questionAnswerService.findByAdminId(id);
    questionAnswerList.forEach(
        questionAnswer -> {
          questionAnswer.setAdministrator(null);
          questionAnswerService.save(questionAnswer);
        });
    userService.deleteById(id);
    return userWrapper.get();
  }


}
