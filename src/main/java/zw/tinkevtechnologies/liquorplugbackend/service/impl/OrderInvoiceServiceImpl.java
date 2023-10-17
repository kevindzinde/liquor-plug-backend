package zw.tinkevtechnologies.liquorplugbackend.service.impl;

import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.OrderInvoice;
import zw.tinkevtechnologies.liquorplugbackend.repository.OrderInvoiceRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.OrderInvoiceService;

@Service
public class OrderInvoiceServiceImpl implements OrderInvoiceService {
    private final OrderInvoiceRepository orderInvoiceRepository;

    public OrderInvoiceServiceImpl(OrderInvoiceRepository orderInvoiceRepository) {
        this.orderInvoiceRepository = orderInvoiceRepository;
    }

    @Override
    public OrderInvoice saveOrderInvoice(OrderInvoice orderInvoice) {
        OrderInvoice orderInvoice1= new OrderInvoice();
        orderInvoice1.setUserid(orderInvoice.getUserid());
        orderInvoice1.setOrderInvoiceId(orderInvoice.getOrderInvoiceId());
        orderInvoice1.setPayment(orderInvoice.getPayment());
        orderInvoice1.setStatus(orderInvoice.getStatus());
        orderInvoice1.setDeliveryDetail(orderInvoice.getDeliveryDetail());
        orderInvoice1.setUserCart(orderInvoice.getUserCart());
        return orderInvoiceRepository.save(orderInvoice1);
    }

    @Override
    public OrderInvoice updateOrderInvoice(OrderInvoice orderInvoice) {
        return orderInvoiceRepository.save(orderInvoice);
    }

    @Override
    public OrderInvoice getOrderInvoiceDetais(String userid) {
        return orderInvoiceRepository.findOrderInvoiceByUserid(userid);
    }
}
