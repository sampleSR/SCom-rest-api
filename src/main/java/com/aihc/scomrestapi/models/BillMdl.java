package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.db.entities.Bill;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BillMdl {
  private Integer id;

  public BillMdl(Bill bill) {
    this.id = bill.getId();
  }
}
