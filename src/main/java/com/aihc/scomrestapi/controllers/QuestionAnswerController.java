package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.QuestionAnswer;
import com.aihc.scomrestapi.services.QuestionAnswerService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.QUESTION_ANSWERS)
public class QuestionAnswerController {

  private final QuestionAnswerService qaService;

  public QuestionAnswerController(final QuestionAnswerService qaService) {
    this.qaService = qaService;
  }

  @PostMapping
  public ResponseEntity<QuestionAnswer> save(@RequestBody QuestionAnswer questionAnswer) {
    return ResponseEntity.ok(qaService.save(questionAnswer));
  }

  @PutMapping("/{id}")
  public ResponseEntity<QuestionAnswer> update(
      @PathVariable Integer id,
      @RequestBody QuestionAnswer questionAnswer,
      @RequestParam Integer adminId) {
    return ResponseEntity.ok(qaService.update(id, questionAnswer, adminId));
  }

  @GetMapping
  public ResponseEntity<List<QuestionAnswer>> getAll() {
    return ResponseEntity.ok(qaService.getAll());
  }

  @GetMapping("/resolved")
  public ResponseEntity<List<QuestionAnswer>> getOnlyWithAnswers() {
    return ResponseEntity.ok(qaService.getAllWithAnswers());
  }
}
