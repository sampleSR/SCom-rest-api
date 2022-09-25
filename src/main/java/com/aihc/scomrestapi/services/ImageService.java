package com.aihc.scomrestapi.services;

import com.aihc.scomrestapi.db.entities.Image;
import com.aihc.scomrestapi.db.entities.Product;
import com.aihc.scomrestapi.repositories.ImageRepository;
import com.aihc.scomrestapi.repositories.ProductRepository;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

  private final ImageRepository imageRepository;

  private final CloudinaryService cloudinaryService;

  private final ProductRepository productRepository;

  public ImageService(
      final ImageRepository imageRepository,
      final CloudinaryService cloudinaryService,
      ProductRepository productRepository) {
    this.imageRepository = imageRepository;
    this.cloudinaryService = cloudinaryService;
    this.productRepository = productRepository;
  }

  public Image save(MultipartFile file) throws IOException {
    Map result = cloudinaryService.upload(file);
    Image image = new Image();
    image.setName((String) result.get("original_filename"));
    image.setUrl((String) result.get("url"));
    image.setPublicId((String) result.get("public_id"));
    return imageRepository.save(image);
  }

  public Image delete(final Integer id) throws IOException {
    Optional<Image> imageWrapper = imageRepository.findById(id);
    if (imageWrapper.isEmpty()) {
      throw new RuntimeException();
    }
    Image image = imageWrapper.get();
    Map result = cloudinaryService.delete(image.getPublicId());
    if (!result.get("result").equals("ok")) {
      throw new RuntimeException();
    }
    imageRepository.delete(image);
    return image;
  }

  public Image update(final Integer productId, final MultipartFile file) throws IOException {
    Optional<Product> productOptional = productRepository.findById(productId);
    if (productOptional.isEmpty()) {
      throw new RuntimeException();
    }
    Product product = productOptional.get();
    Map resultDel = cloudinaryService.delete(product.getImage().getPublicId());
    if (!resultDel.get("result").equals("ok")) {
      throw new RuntimeException();
    }
    Map result = cloudinaryService.upload(file);
    product.getImage().setName((String) result.get("original_filename"));
    product.getImage().setUrl((String) result.get("url"));
    product.getImage().setPublicId((String) result.get("public_id"));
    return imageRepository.save(product.getImage());
  }
}
