package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.db.entities.Image;
import com.aihc.scomrestapi.services.ImageService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(EndPoint.IMAGES)
public class ImageController {

  private final ImageService imageService;

  public ImageController(final ImageService imageService) {
    this.imageService = imageService;
  }

  @PostMapping(consumes = "multipart/form-data")
  public ResponseEntity<Image> upload(@RequestParam MultipartFile file) throws IOException {
    return ResponseEntity.ok(imageService.save(file));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Image> delete(@PathVariable Integer id) throws IOException {
    return ResponseEntity.ok(imageService.delete(id));
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Image> update(@PathVariable Integer id, @RequestParam MultipartFile file)
      throws IOException {
    return ResponseEntity.ok(imageService.update(id, file));
  }
}
