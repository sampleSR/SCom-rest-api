package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

  List<Order> findByDateBillBetween(Date start, Date end);

  List<Order> findAllByChef_Id(final Integer id);
  // TODO: When customer is added, uncomment the line below
  // List<Order> findAllByCustomer_Id(final Integer id);
}
