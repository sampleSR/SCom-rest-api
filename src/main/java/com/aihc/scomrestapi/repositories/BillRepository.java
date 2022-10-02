package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Bill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
  List<Bill> findAllByCustomer_Id(final Integer customer_id);

  List<Bill> findAllByCashier_Id(final Integer id);
}
