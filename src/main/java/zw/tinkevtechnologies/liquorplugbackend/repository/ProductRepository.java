package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.tinkevtechnologies.liquorplugbackend.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByProductCode(String productCode);


}
