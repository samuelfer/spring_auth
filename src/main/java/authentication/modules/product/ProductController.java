package authentication.modules.product;

import authentication.modules.product.entities.Product;
import authentication.modules.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  ProductService productService;

  @GetMapping
  public List<Product> list() {
    return productService.listAll();
  }

  @PostMapping
  public ResponseEntity<Product> save(@RequestBody Product product) {
    try {
      return productService.save(product);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

}
