package authentication.modules.product.services;

import java.util.List;

import authentication.modules.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import authentication.modules.product.repositories.ProductRepository;

@Service
public class ListProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> listAll() {
    return productRepository.findAll();
  }
}
