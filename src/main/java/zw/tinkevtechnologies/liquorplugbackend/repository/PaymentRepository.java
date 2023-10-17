package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.tinkevtechnologies.liquorplugbackend.model.Payment;

public interface PaymentRepository  extends JpaRepository<Payment,Long> {
}
