package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Bill;
import com.aihc.scomrestapi.repositories.BillRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BillService {
  private final BillRepository billRepository;

  public BillService(final BillRepository billRepository) {
    this.billRepository = billRepository;
  }

  public List<Bill> findByCustomerId(Integer customerId) {
    return billRepository.findAllByCustomer_Id(customerId);
  }

  public Bill save(final Bill bill) {
    return billRepository.save(bill);
  }

  public List<Bill> findByCashierId(Integer id) {
    return billRepository.findAllByCashier_Id(id);
  }
}
