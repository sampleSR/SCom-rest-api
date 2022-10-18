package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = TableConstants.PRODUCT_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.PRODUCT_ID)
  @JsonProperty(access = Access.READ_ONLY)
  private Integer id;

  @Column(name = TableConstants.PRICE)
  private Double price;

  @Column(name = TableConstants.AVAILABLE)
  private Boolean available;

  @Column(name = TableConstants.DELETED)
  private Boolean deleted = false;

  @Column(name = TableConstants.DESCRIPTION)
  private String description = "";

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  @JsonIgnore
  Set<OrderProduct> orders = new HashSet<>();

  @JsonProperty(access = Access.READ_ONLY)
  @Transient
  private String urlImage;

  @Transient private Integer imageId;

  @OneToOne
  @JoinColumn(name = TableConstants.IMAGE_AS_FOREIGN)
  @JsonIgnore
  private Image image;
}
