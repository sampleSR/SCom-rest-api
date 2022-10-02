package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.QuestionAnswer;
import com.aihc.scomrestapi.repositories.QuestionAnswerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerService {

  private final QuestionAnswerRepository qaRepository;
  private final AdministratorService administratorService;

  public QuestionAnswerService(
      final QuestionAnswerRepository qaRepository, AdministratorService administratorService) {
    this.qaRepository = qaRepository;
    this.administratorService = administratorService;
  }

  public QuestionAnswer save(QuestionAnswer questionAnswer) {
    return qaRepository.save(questionAnswer);
  }

  public QuestionAnswer update(Integer id, QuestionAnswer questionAnswer, Integer adminId) {
    Optional<QuestionAnswer> qaWrapper = qaRepository.findById(id);
    if (qaWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    questionAnswer.setId(id);
    questionAnswer.setAdministrator(administratorService.findById(adminId));
    return qaRepository.save(questionAnswer);
  }

  public QuestionAnswer getById(Integer id) {
    Optional<QuestionAnswer> qaWrapper = qaRepository.findById(id);
    if (qaWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    return qaWrapper.get();
  }

  public List<QuestionAnswer> getAll() {
    return qaRepository.findAll();
  }

  public QuestionAnswer deleteById(Integer id) {
    QuestionAnswer questionAnswer = getById(id);
    qaRepository.delete(questionAnswer);
    return questionAnswer;
  }

  public List<QuestionAnswer> getAllWithAnswers() {
    return qaRepository.findByAnswerIsNotNull();
  }

  public List<QuestionAnswer> findByAdminId(Integer id) {
    return qaRepository.findAllByAdministrator_Id(id);
  }
}
