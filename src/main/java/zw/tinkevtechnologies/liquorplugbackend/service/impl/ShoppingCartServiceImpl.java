package zw.tinkevtechnologies.liquorplugbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.UserCart;
import zw.tinkevtechnologies.liquorplugbackend.repository.UserCartRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.ShoppingCartService;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private UserCartRepository cartRepository;

    @Override
    public List<UserCart> listCartItems(User user) {
        return  cartRepository.findAllByUser(user);
    }
}
