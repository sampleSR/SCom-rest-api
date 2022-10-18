package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.dtos.AvailableProductDTO;
import com.aihc.scomrestapi.repositories.ProductRepository;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void switchAvailable(final Integer id, final AvailableProductDTO newState) {
    Optional<Product> productOptional = productRepository.findById(id);
    if (productOptional.isEmpty()) {
      throw new RuntimeException();
    }
    Product product = productOptional.get();
    if (!Objects.equals(product.getId(), newState.getId())) {
      throw new RuntimeException();
    }
    product.setAvailable(newState.getAvailable());
    productRepository.save(product);
  }

  public Product getById(final Integer id) {
    Optional<Product> optionalProduct = productRepository.findById(id);
    if (optionalProduct.isEmpty()) {
      throw new RuntimeException();
    }
    return optionalProduct.get();
  }

  public Product deleteById(final Integer id) {
    Product product = getById(id);
    product.setDeleted(true);
    productRepository.save(product);
    return product;
  }
}
