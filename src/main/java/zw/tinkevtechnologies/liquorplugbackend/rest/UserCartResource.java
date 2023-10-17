package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.tinkevtechnologies.liquorplugbackend.exception.ProductException;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.model.UserCart;
import zw.tinkevtechnologies.liquorplugbackend.service.api.UserCartService;

@RestController
@RequestMapping("/api/cart")
public class UserCartResource {
    @Autowired
    private UserCartService userCartService;
    private final Logger logger = LoggerFactory.getLogger(UserCartResource.class);
    @PostMapping("/save")
    public ResponseEntity<?> createUserCart(@RequestBody UserCart userCart) throws ProductException {
        logger.info("<<<<<<<<<<<<<<<<<<< Saving usercart >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(userCart);
        return  new ResponseEntity<>(userCartService.saveUserCart(userCart), HttpStatus.CREATED);

    }
    @PostMapping("/update")
    public ResponseEntity<?> updateUserCart(@RequestBody UserCart userCart) throws ProductException {
        logger.info("<<<<<<<<<<<<<<<<<<< updating usercart with id {}>>>>>>>>>>>>>>>>>>>>>>>>>>>",userCart.getId());
        return  new ResponseEntity<>(userCartService.saveUserCart(userCart), HttpStatus.CREATED);

    }

    @GetMapping("/user")
    public ResponseEntity<?> getShoppingCart(@RequestBody User user){
        User newUser= new User();
        newUser.setId(user.getId());
        return  new ResponseEntity<>(userCartService.getUserCart(newUser.getId()),HttpStatus.OK);
    }
}
