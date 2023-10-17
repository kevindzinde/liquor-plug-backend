package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    void deleteProduct(Long id);

    Product getProduct(Long id);

    List<Product> findAllProducts();

    Product updateProduct(Product product);

    Product searchProduct(String productCode);
}
