package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = TableConstants.PRODUCT_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.PRODUCT_ID)
  private Integer id;

  @Column(name = TableConstants.PRICE)
  private Double price;

  @OneToMany(mappedBy = "product")
  Set<OrderProduct> orders;
}
