package zw.tinkevtechnologies.liquorplugbackend.service.impl;

import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.Payment;
import zw.tinkevtechnologies.liquorplugbackend.repository.PaymentRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.PaymentService;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {
        Payment userPayment= new Payment();
        userPayment.setPaymentId(payment.getPaymentId());
        userPayment.setPaymentType(payment.getPaymentType());
        userPayment.setCurrency(payment.getCurrency());
        userPayment.setAmountPaid(payment.getAmountPaid());
        userPayment.setPaymentDate(LocalDateTime.now());
        return paymentRepository.save(userPayment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
