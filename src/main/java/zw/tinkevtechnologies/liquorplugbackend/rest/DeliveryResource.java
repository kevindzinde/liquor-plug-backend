package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.tinkevtechnologies.liquorplugbackend.model.DeliveryDetail;
import zw.tinkevtechnologies.liquorplugbackend.service.api.DeliveryService;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryResource {

    @Autowired
    private DeliveryService deliveryService;
    private final Logger logger = LoggerFactory.getLogger(DeliveryResource.class);
    @PostMapping("/save")
    public ResponseEntity<?> createDetails(@RequestBody DeliveryDetail deliveryDetail){
        return  new ResponseEntity<>(deliveryService.saveDelivery(deliveryDetail), HttpStatus.CREATED);

    }
    @PutMapping("/update")
    public ResponseEntity<?> updateDetails(@RequestBody DeliveryDetail deliveryDetail){
        return  new ResponseEntity<>(deliveryService.updateDelivery(deliveryDetail), HttpStatus.CREATED);

    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> getDeliveryDetails(@PathVariable Long userid){
        return  new ResponseEntity<>(deliveryService.getDeliveryInformation(userid),HttpStatus.OK);
    }
}
