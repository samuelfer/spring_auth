package authentication.modules.product.services;

import java.util.List;
import java.util.Optional;

import authentication.modules.product.dto.ProductDTO;
import authentication.modules.product.entities.Product;
import authentication.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import authentication.modules.product.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> listAll() {
    return productRepository.findAll();
  }

  public ResponseEntity<Product> save(Product product) {

    Optional<Product> existsProduct = productRepository.findFirstByName(product.getName());

    if (existsProduct.isPresent()) {
      throw new RuntimeException("Product already exists!");
    }

    return new ResponseEntity(productRepository.save(product), HttpStatus.CREATED);
  }
}
