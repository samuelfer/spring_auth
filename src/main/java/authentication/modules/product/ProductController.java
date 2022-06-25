package authentication.modules.product;

import java.util.List;

import authentication.modules.product.entities.Product;
import authentication.modules.product.services.ListProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  ListProductService listProductService;

  @GetMapping
  public List<Product> list() {
    return listProductService.listAll();
  }

}