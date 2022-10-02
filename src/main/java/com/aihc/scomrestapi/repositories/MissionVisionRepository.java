package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.MissionVision;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionVisionRepository extends JpaRepository<MissionVision, Integer> {
  List<MissionVision> findAllByAdministrator_Id(final Integer id);

}
