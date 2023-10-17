package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.DeliveryDetail;

public interface DeliveryService {
    DeliveryDetail saveDelivery(DeliveryDetail deliveryDetail);
    DeliveryDetail updateDelivery(DeliveryDetail deliveryDetail);

    DeliveryDetail getDeliveryInformation(Long userId);
}
