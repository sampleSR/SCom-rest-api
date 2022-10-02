package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Administrator;
import com.aihc.scomrestapi.db.entities.MissionVision;
import com.aihc.scomrestapi.db.entities.QuestionAnswer;
import com.aihc.scomrestapi.repositories.AdministratorRepository;
import com.aihc.scomrestapi.repositories.MissionVisionRepository;
import com.aihc.scomrestapi.repositories.QuestionAnswerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

  private final AdministratorRepository administratorRepository;
  private final AuthenticationService authenticationService;
  private final MissionVisionRepository mvRepository;
  private final UserService userService;
  private final QuestionAnswerRepository qaRepository;

  public AdministratorService(
      AdministratorRepository administratorRepository,
      AuthenticationService authenticationService,
      MissionVisionRepository mvRepository,
      UserService userService,
      QuestionAnswerRepository qaRepository) {
    this.administratorRepository = administratorRepository;
    this.authenticationService = authenticationService;
    this.mvRepository = mvRepository;
    this.userService = userService;
    this.qaRepository = qaRepository;
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
    List<MissionVision> missionVisionList = mvRepository.findAllByAdministrator_Id(id);
    missionVisionList.forEach(
        missionVision -> {
          missionVision.setAdministrator(null);
          mvRepository.save(missionVision);
        });
    List<QuestionAnswer> questionAnswerList = qaRepository.findAllByAdministrator_Id(id);
    questionAnswerList.forEach(
        questionAnswer -> {
          questionAnswer.setAdministrator(null);
          qaRepository.save(questionAnswer);
        });
    userService.deleteById(id);
    return userWrapper.get();
  }
}
