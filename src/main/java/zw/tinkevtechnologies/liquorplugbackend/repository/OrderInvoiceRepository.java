package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.tinkevtechnologies.liquorplugbackend.model.OrderInvoice;

public interface OrderInvoiceRepository extends JpaRepository<OrderInvoice,Long> {
    OrderInvoice findOrderInvoiceByUserid(String userid);
}
