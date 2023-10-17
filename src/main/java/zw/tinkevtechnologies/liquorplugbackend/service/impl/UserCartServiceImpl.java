package zw.tinkevtechnologies.liquorplugbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.exception.ProductException;
import zw.tinkevtechnologies.liquorplugbackend.model.Product;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.UserCart;
import zw.tinkevtechnologies.liquorplugbackend.repository.CartRepository;
import zw.tinkevtechnologies.liquorplugbackend.repository.UserCartRepository;
import zw.tinkevtechnologies.liquorplugbackend.repository.UserRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.ProductService;
import zw.tinkevtechnologies.liquorplugbackend.service.api.UserCartService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserCartServiceImpl implements UserCartService {
    private  final UserCartRepository userCartRepository;
    private final ProductService productService;

    @Autowired
    private UserCartRepository cartRepository;
    private final UserRepository userRepository;


    public UserCartServiceImpl(UserCartRepository userCartRepository, ProductService productService, UserCartRepository cartRepository,
                               UserRepository userRepository) {
        this.userCartRepository = userCartRepository;
        this.productService = productService;

        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserCart saveUserCart(UserCart userCart) throws ProductException {
        Product selectedProducts = userCart.getProduct();
        List<Product> userProducts= new ArrayList<>();
        userProducts.add(selectedProducts);
        for (Product cart : userProducts) {
            Product product = productService.searchProduct(cart.getProductCode());
            if (product != null) {
                int newQuantity = product.getQuantity() - userCart.getQuantity();
                if (newQuantity < 0) {
                    throw new ProductException("Insufficient quantity for product with code: " + product.getProductCode());
                }
                product.setQuantity(newQuantity);
                Product updateProduct = productService.updateProduct(product);
                userCart.setProduct(updateProduct);

            } else {
                throw new ProductException("No product found with code: " + cart.getProductCode());
            }
        }



        UserCart savedUserCart = userCartRepository.save(userCart);

        return savedUserCart;
    }

    @Override
    public UserCart updateUserCart(UserCart userCart) {
        return userCartRepository.save(userCart);
    }

    @Override
    public List<UserCart> getUserCart(Long userid) {

        User user2 = userRepository.findById(userid).get();
//        userRepository.save(user1);
        return userCartRepository.findAllByUser(user2);
    }
}
