package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.*;
import com.aihc.scomrestapi.repositories.OrderRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import com.aihc.scomrestapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

  private final OrderRepository orderRepository;
  private final UserRepository userRepository;

  public StatsService(OrderRepository orderRepository, UserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
  }

  public Double getIncomes(int month, int year) {

    LocalDate start = LocalDate.of(year, month, 1);
    LocalDate end = start.plusMonths(1);
    ZoneId defaultZoneId = ZoneId.systemDefault();

    Date startDate = Date.from(start.atStartOfDay(defaultZoneId).toInstant());
    Date endDate = Date.from(end.atStartOfDay(defaultZoneId).toInstant());

    List<Order> orders = orderRepository.findByDateBillBetween(startDate, endDate);
    AtomicReference<Double> incomes = new AtomicReference<>((double) 0);
    orders.forEach(
        order -> {
          order
              .getProducts()
              .forEach(
                  orderProduct -> {
                    incomes.updateAndGet(
                        v -> v + orderProduct.getAmount() * orderProduct.getProduct().getPrice());
                  });
        });

    return incomes.get();
  }
    public Double getExpenses(int month, int year) {

        List<User> users = userRepository.findAll();
        AtomicReference<Double> expenses = new AtomicReference<>(0.0);
        users.forEach(user -> {
            if (user instanceof Administrator) {
                expenses.updateAndGet(e -> e + ((Administrator) user).getSalary());
            }
            if (user instanceof Cashier) {
                expenses.updateAndGet(e -> e + ((Cashier) user).getSalary());
            }
            if (user instanceof Chef) {
                expenses.updateAndGet(e -> e + ((Chef) user).getSalary());
            }
            if (user instanceof Waiter) {
                expenses.updateAndGet(e -> e + ((Waiter) user).getSalary());
            }
        });
        // TODO: Perhaps will be necessary add ingredient prices and filter user for employee contract date
        return expenses.get();

    }
}
