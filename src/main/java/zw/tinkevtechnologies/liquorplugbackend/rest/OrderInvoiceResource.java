package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.tinkevtechnologies.liquorplugbackend.model.OrderInvoice;
import zw.tinkevtechnologies.liquorplugbackend.model.UserCart;
import zw.tinkevtechnologies.liquorplugbackend.service.api.OrderInvoiceService;

@RestController
@RequestMapping("/api/order")
public class OrderInvoiceResource {
    @Autowired
    private OrderInvoiceService orderInvoiceService;
    private final Logger logger = LoggerFactory.getLogger(OrderInvoiceResource.class);
    @PostMapping("/save")
    public ResponseEntity<?> createOrder(@RequestBody OrderInvoice orderInvoice){
        logger.info("<<<<<<<<<<<<<<<<<<< Saving order with id {}>>>>>>>>>>>>>>>>>>>>>>>>>>>",orderInvoice.getUserid());
        return  new ResponseEntity<>(orderInvoiceService.saveOrderInvoice(orderInvoice), HttpStatus.CREATED);

    }
    @PostMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody OrderInvoice orderInvoice){
        logger.info("<<<<<<<<<<<<<<<<<<< updating order with id {}>>>>>>>>>>>>>>>>>>>>>>>>>>>",orderInvoice.getUserid());
        return  new ResponseEntity<>(orderInvoiceService.saveOrderInvoice(orderInvoice), HttpStatus.CREATED);

    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> getOrderDetails(@PathVariable String userid){
        return  new ResponseEntity<>(orderInvoiceService.getOrderInvoiceDetais(userid),HttpStatus.OK);
    }

}
