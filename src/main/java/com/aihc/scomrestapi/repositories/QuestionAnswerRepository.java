package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.QuestionAnswer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Integer> {

  List<QuestionAnswer> findByAnswerIsNotNull();
  List<QuestionAnswer> findAllByAdministrator_Id(final Integer adminId);

}
