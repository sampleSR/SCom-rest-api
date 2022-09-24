package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.USER_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

  @Id
  @Column(name = TableConstants.USER_ID)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @Column(name = TableConstants.ADDRESS_USER)
  private String address;

  @Transient
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String role;
}
