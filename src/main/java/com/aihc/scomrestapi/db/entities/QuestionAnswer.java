package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.QUESTION_ANSWER)
public class QuestionAnswer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.QUESTION_ANSWER_ID)
  private Integer id;

  @Column(name = TableConstants.QUESTION)
  private String question;

  @Column(name = TableConstants.ANSWER)
  private String answer;

  @ManyToOne
  @JoinColumn(name = TableConstants.ADMINISTRATOR_AS_FOREIGN)
  private Administrator administrator;
}
