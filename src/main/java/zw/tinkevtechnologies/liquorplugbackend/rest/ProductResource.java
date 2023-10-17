package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.tinkevtechnologies.liquorplugbackend.model.Product;
import zw.tinkevtechnologies.liquorplugbackend.service.api.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductResource {
    @Autowired
    private  ProductService productService;
@PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){

    return  new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);


    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
    productService.deleteProduct(productId);
    return  new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping("/get-all-products")
    public ResponseEntity<?> getAllProducts(){
    return  new ResponseEntity<>(productService.findAllProducts(),HttpStatus.OK);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId){
    return  new ResponseEntity<>(productService.getProduct(productId),HttpStatus.OK);
    }
}
