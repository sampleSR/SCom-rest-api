package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.MISSION_VISION)
public class MissionVision {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.MISSION_VISION_ID)
  private Integer id;

  @Column(name = TableConstants.MISSION, length = TableConstants.MISSION_LENGTH)
  private String mission;

  @Column(name = TableConstants.VISION, length = TableConstants.VISION_LENGTH)
  private String vision;

  @Column(name = TableConstants.DATE)
  @JsonIgnore
  private LocalDate date;

  @Transient private Integer adminId;

  @ManyToOne
  @JoinColumn(name = TableConstants.ADMINISTRATOR_AS_FOREIGN)
  @JsonIgnore
  private Administrator administrator;
}
