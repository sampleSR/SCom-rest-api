package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.IMAGE)
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.IMAGE_ID)
  private Integer id;

  @Column(name = TableConstants.NAME)
  private String name;

  @Column(name = TableConstants.PUBLIC_ID)
  private String publicId;

  private String url;
}
