package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

  List<Order> findByDateBillBetween(Date start, Date end);
}
