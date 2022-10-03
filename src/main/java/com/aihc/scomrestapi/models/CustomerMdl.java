package com.aihc.scomrestapi.models;

import com.aihc.scomrestapi.db.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerMdl
{
    private Integer id;

    public CustomerMdl(Customer customer) {
        this.id = customer.getId();
    }
}
