package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.MissionVision;
import com.aihc.scomrestapi.repositories.MissionVisionRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MissionVisionService {
  private final MissionVisionRepository mvRepository;
  private final AdministratorService administratorService;

  public MissionVisionService(
      final MissionVisionRepository mvRepository, AdministratorService administratorService) {
    this.mvRepository = mvRepository;
    this.administratorService = administratorService;
  }

  public MissionVision save(MissionVision missionVision) {
    missionVision.setDate(LocalDate.now());
    missionVision.setAdministrator(administratorService.findById(missionVision.getAdminId()));
    return mvRepository.save(missionVision);
  }

  public MissionVision findLast() {
    List<MissionVision> missionVisionList = mvRepository.findAll();
    if (missionVisionList.size() == 0) {
      return new MissionVision();
    }
    return missionVisionList.get(missionVisionList.size() - 1);
  }

  public List<MissionVision> findByAdminId(Integer adminId) {
    return mvRepository.findAllByAdministrator_Id(adminId);
  }
}
