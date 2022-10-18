package com.aihc.scomrestapi.controllers;

import com.aihc.scomrestapi.dtos.AvailableProductDTO;
import com.aihc.scomrestapi.services.ProductService;
import com.aihc.scomrestapi.utils.constants.EndPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoint.PRODUCTS)
public class ProductController {

  private final ProductService productService;

  public ProductController(final ProductService productService) {
    this.productService = productService;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> switchAvailable(
      @RequestBody AvailableProductDTO newState, @PathVariable Integer id) {
    productService.switchAvailable(id, newState);
    return ResponseEntity.accepted().body("Update successful");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    return ResponseEntity.ok().body(productService.deleteById(id));
  }
}
