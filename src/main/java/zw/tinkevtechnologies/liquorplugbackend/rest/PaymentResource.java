package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.tinkevtechnologies.liquorplugbackend.model.Payment;
import zw.tinkevtechnologies.liquorplugbackend.service.api.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentResource {
    @Autowired
    private PaymentService paymentService;
    private final Logger logger = LoggerFactory.getLogger(PaymentResource.class);
    @PostMapping("/save")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment){
        logger.info("<<<<<<<<<<<<<<<<<<< SAving payment with id {}>>>>>>>>>>>>>>>>>>>>>>>>>>>",payment.getPaymentId());
        return  new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.CREATED);

    }
    @PostMapping("/update")
    public ResponseEntity<?> updatePaymentDetails(@RequestBody Payment payment){
        logger.info("<<<<<<<<<<<<<<<<<<< updating  payment with id {}>>>>>>>>>>>>>>>>>>>>>>>>>>>",payment.getPaymentId());
        return  new ResponseEntity<>(paymentService.updatePayment(payment), HttpStatus.CREATED);

    }
}
