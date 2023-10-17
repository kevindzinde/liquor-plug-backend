package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.Payment;

public interface PaymentService {
    Payment savePayment(Payment payment);
    Payment updatePayment(Payment payment);


}
