package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.USER_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

  @Id
  @Column(name = TableConstants.USER_ID)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = TableConstants.USERNAME)
  private String username;

  @Column(name = TableConstants.FATHER_LASTNAME)
  private String fatherLastname;

  @Column(name = TableConstants.MOTHER_LASTNAME)
  private String motherLastname;

  @Column(name = TableConstants.NAME)
  private String name;

  @Column(name = TableConstants.EMAIL)
  private String email;

  @Column(name = TableConstants.PASSWORD)
  private String password;

  @Column(name = TableConstants.ADDRESS_USER)
  private String address;
}
