package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.UserCart;

import java.util.List;

public interface ShoppingCartService {
     List<UserCart> listCartItems(User user);


}
