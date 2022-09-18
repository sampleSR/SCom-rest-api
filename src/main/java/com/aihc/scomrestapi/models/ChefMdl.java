package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.db.entities.Chef;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChefMdl {

  private Integer id;

  public ChefMdl(Chef chef) {
    this.id = chef.getId();
  }

  public Chef toEntity() {
    Chef chef = new Chef();
    chef.setId(id);
    return chef;
  }
}
