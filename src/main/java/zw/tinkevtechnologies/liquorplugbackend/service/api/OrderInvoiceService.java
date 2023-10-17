package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.OrderInvoice;

public interface OrderInvoiceService {
    OrderInvoice saveOrderInvoice(OrderInvoice orderInvoice);
    OrderInvoice updateOrderInvoice(OrderInvoice orderInvoice);
    OrderInvoice getOrderInvoiceDetais(String userid);

}
