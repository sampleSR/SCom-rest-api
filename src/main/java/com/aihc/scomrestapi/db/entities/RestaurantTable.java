package com.aihc.scomrestapi.db.entities;

import com.aihc.scomrestapi.utils.constants.TableConstants;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableConstants.TABLE_REST_TABLE)
public class RestaurantTable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = TableConstants.TABLE_ID)
  private Integer id;

  @Column(name = TableConstants.CAPACITY)
  private Integer capacity;

  @Column(name = TableConstants.NUMBER)
  private String number;

  @ManyToMany(mappedBy = "tables")
  Set<Waiter> waiters;
}
