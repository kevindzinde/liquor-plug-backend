package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.exception.ProductException;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.UserCart;

import java.util.List;

public interface UserCartService {
    UserCart saveUserCart(UserCart userCart) throws ProductException;
    UserCart updateUserCart(UserCart userCart);

    List<UserCart> getUserCart(Long user);

}
