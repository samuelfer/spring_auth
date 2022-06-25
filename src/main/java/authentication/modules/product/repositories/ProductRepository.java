package authentication.modules.product.repositories;

import java.util.Optional;
import java.util.UUID;

import authentication.modules.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findFirstByName(String name);

}
