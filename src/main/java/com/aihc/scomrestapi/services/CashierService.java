package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Bill;
import com.aihc.scomrestapi.db.entities.Cashier;
import com.aihc.scomrestapi.repositories.BillRepository;
import com.aihc.scomrestapi.repositories.CashierRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CashierService {

  private final CashierRepository cashierRepository;
  private final AuthenticationService authenticationService;
  private final BillRepository billRepository;
  private final UserService userService;

  public CashierService(
      CashierRepository cashierRepository,
      AuthenticationService authenticationService,
      BillRepository billRepository,
      UserService userService) {
    this.cashierRepository = cashierRepository;
    this.authenticationService = authenticationService;
    this.billRepository = billRepository;
    this.userService = userService;
  }

  public Cashier save(Cashier cashier) {
    return cashierRepository.save(cashier);
  }

  public Cashier findById(Integer id) {
    Optional<Cashier> adminWrapper = cashierRepository.findById(id);
    if (adminWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Cashier cashier = adminWrapper.get();
    cashier.setRole(authenticationService.getRoleByUserId(cashier.getId()));
    return cashier;
  }

  public Cashier update(final Integer id, final Cashier cashier) {
    Optional<Cashier> cashierWrapper = cashierRepository.findById(id);
    if (cashierWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    cashier.setId(id);
    cashier.setPassword(cashierWrapper.get().getPassword());
    cashier.setRole(authenticationService.getRoleByUserId(id));
    return cashierRepository.save(cashier);
  }

  public Cashier deleteById(final Integer id) {
    Optional<Cashier> userWrapper = cashierRepository.findById(id);
    if (userWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    List<Bill> billList = billRepository.findAllByCashier_Id(id);
    billList.forEach(
        bill -> {
          bill.setCashier(null);
          billRepository.save(bill);
        });

    userService.deleteById(id);
    return userWrapper.get();
  }
}
