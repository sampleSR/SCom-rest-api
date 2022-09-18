package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.models.ProductMdl;
import com.aihc.scomrestapi.utils.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = TableConstants.ORDER_TABLE)
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.ORDER_ID)
  private Integer id;

  @Column(name = TableConstants.DATE)
  private Date date;

  @Column(name = TableConstants.DATE_BILL)
  private Date dateBill;

  @ManyToOne
  @JoinColumn(name = TableConstants.BILL_AS_FOREIGN)
  private Bill bill;

  @ManyToOne
  @JoinColumn(name = TableConstants.RESTAURANT_TABLE_AS_FOREIGN)
  private RestaurantTable table;

  @ManyToOne
  @JoinColumn(name = TableConstants.CHEF_AS_FOREIGN)
  private Chef chef;

  @OneToMany(mappedBy = "order",
      cascade = CascadeType.ALL
  )
  Set<OrderProduct> products = new HashSet<>();


  public OrderMdl toModel() {
    OrderMdl orderMdl = new OrderMdl();
    orderMdl.setId(id);
    List<ProductMdl> productMdls = new ArrayList<>();
    products.forEach(p -> {
      ProductMdl productMdl = new ProductMdl();
      productMdl.setId(p.getProduct().getId());
      productMdl.setDescription(p.getAmount()+"");
      productMdls.add(productMdl);
    });
    orderMdl.setProducts(productMdls);
    return orderMdl;
  }

}
