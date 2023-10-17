package zw.tinkevtechnologies.liquorplugbackend.service.impl;


import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.Product;
import zw.tinkevtechnologies.liquorplugbackend.repository.ProductRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.ProductService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product saveProduct(Product product){
        Product newProduct= new Product();
        newProduct.setDatecreated(LocalDateTime.now());
        newProduct.setProductCode(product.getProductCode());
        newProduct.setPrice(product.getPrice());
        newProduct.setBrand(product.getBrand());
        newProduct.setStatus(product.getStatus());
        newProduct.setDescription(product.getDescription());
        newProduct.setProductCatergory(product.getProductCatergory());
        newProduct.setQuantity(product.getQuantity());


        return  productRepository.save(newProduct);

    }
    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAllProducts(){
        return  productRepository.findAll();

    }

    @Override
    public Product updateProduct(Product product) {
        // Retrieve the existing product from the database
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);

        // Check if the product exists
        if (existingProduct != null) {
            // Update the fields of the existing product with the new values
            existingProduct.setProductCode(product.getProductCode());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setStatus(product.getStatus());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setProductCatergory(product.getProductCatergory());
            existingProduct.setQuantity(product.getQuantity());

            // Save the updated product to the database
            return productRepository.save(existingProduct);
        }

        return null; // Return null if the product doesn't exist
    }

    @Override
    public Product searchProduct(String productCode) {
        return productRepository.findProductByProductCode(productCode);
    }
}
