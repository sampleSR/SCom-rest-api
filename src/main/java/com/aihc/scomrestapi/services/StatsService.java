package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Order;
import com.aihc.scomrestapi.repositories.OrderRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

  private final OrderRepository orderRepository;

  public StatsService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
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
}
