package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.MissionVision;
import com.aihc.scomrestapi.services.MissionVisionService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.MISSION_VISION)
public class MissionVisionController {

  private final MissionVisionService missionVisionService;

  public MissionVisionController(final MissionVisionService missionVisionService) {
    this.missionVisionService = missionVisionService;
  }

  @PostMapping
  public ResponseEntity<MissionVision> save(@RequestBody MissionVision missionVision) {
    return ResponseEntity.ok(missionVisionService.save(missionVision));
  }

  @GetMapping("/last")
  public ResponseEntity<MissionVision> save() {
    return ResponseEntity.ok(missionVisionService.findLast());
  }
}
