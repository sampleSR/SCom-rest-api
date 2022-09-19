package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.util.Date;
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
@Table(name = TableConstants.RATING_TABLE)
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.RATING_ID)
  private Integer id;

  @Column(name = TableConstants.VALUE)
  private Integer value;

  @Column(name = TableConstants.MESSAGE)
  private String message;

  @Column(name = TableConstants.DATE)
  private Date date;

  @ManyToOne
  @JoinColumn(name = TableConstants.CUSTOMER_AS_FOREIGN)
  private Customer customer;
}
