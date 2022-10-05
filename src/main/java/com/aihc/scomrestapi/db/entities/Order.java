package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.models.BillMdl;
import com.aihc.scomrestapi.models.ChefMdl;
import com.aihc.scomrestapi.models.CustomerMdl;
import com.aihc.scomrestapi.models.OrderMdl;
import com.aihc.scomrestapi.models.ProductMdl;
import com.aihc.scomrestapi.models.RestaurantTableMdl;
import com.aihc.scomrestapi.utils.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

  @Column(name = TableConstants.WAITER_CONFIRMED)
  private Boolean waiterConfirmed = false;

  @Column(name = TableConstants.PREPARED)
  private Boolean prepared = false;

  @Column(name = TableConstants.DELIVERED)
  private Boolean delivered = false;

  @ManyToOne
  @JoinColumn(name = TableConstants.BILL_AS_FOREIGN)
  private Bill bill;

  @ManyToOne
  @JoinColumn(name = TableConstants.RESTAURANT_TABLE_AS_FOREIGN)
  private RestaurantTable table;

  @ManyToOne
  @JoinColumn(name = TableConstants.CHEF_AS_FOREIGN)
  private Chef chef;

  @ManyToOne
  @JoinColumn(name = TableConstants.CUSTOMER_AS_FOREIGN)
  private Customer customer;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  Set<OrderProduct> products = new HashSet<>();

  public OrderMdl toModel() {
    OrderMdl orderMdl = new OrderMdl();
    orderMdl.setId(id);
    orderMdl.setDate(date);
    if (table != null) {
      orderMdl.setTable(new RestaurantTableMdl(table));
    }
    if (chef != null) {
      orderMdl.setChef(new ChefMdl(chef));
    }
    if (customer != null) {
      orderMdl.setCustomer(new CustomerMdl(customer));
    }
    if (bill != null) {
      orderMdl.setBill(new BillMdl(bill));
    }
    Set<ProductMdl> productSet = new HashSet<>();
    products.forEach(
        p -> {
          ProductMdl productMdl = new ProductMdl();
          productMdl.setId(p.getProduct().getId());
          productMdl.setAmount(p.getAmount());
          if (p.getProduct() instanceof Food) {
            productMdl.setType("food");
            productMdl.setNameOrBrand(((Food) p.getProduct()).getName());
          }
          if (p.getProduct() instanceof Drink) {
            productMdl.setType("drink");
            productMdl.setNameOrBrand(((Drink) p.getProduct()).getBrand());
          }
          productSet.add(productMdl);
        });
    orderMdl.setProducts(productSet);
    return orderMdl;
  }
}
