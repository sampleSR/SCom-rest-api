package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.dtos.StatsDTO;
import com.aihc.scomrestapi.services.StatsService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(EndPoint.STATS)
public class StatsController {

   private final StatsService statsService;

  public StatsController(StatsService statsService) {
    this.statsService = statsService;
  }

  @GetMapping("/income-expenses")
  public ResponseEntity<List<StatsDTO>> getStats(@RequestParam Integer month, @RequestParam Integer year) {
    List<StatsDTO> statsDTOList = new ArrayList<>();
    statsDTOList.add(new StatsDTO("income", statsService.getIncomes(month, year)+""));
    statsDTOList.add(new StatsDTO("expenses", statsService.getExpenses(month, year)+""));
    return ResponseEntity.ok(statsDTOList);
  }
}
