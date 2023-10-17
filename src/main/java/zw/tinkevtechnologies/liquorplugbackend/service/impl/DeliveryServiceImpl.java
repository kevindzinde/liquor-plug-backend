package zw.tinkevtechnologies.liquorplugbackend.service.impl;

import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.DeliveryDetail;
import zw.tinkevtechnologies.liquorplugbackend.repository.DeliveryDetailRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryDetailRepository deliveryDetailRepository;

    public DeliveryServiceImpl(DeliveryDetailRepository deliveryDetailRepository) {
        this.deliveryDetailRepository = deliveryDetailRepository;
    }

    @Override
    public DeliveryDetail saveDelivery(DeliveryDetail deliveryDetail) {
        DeliveryDetail deliveryDetail1 = new DeliveryDetail();
        deliveryDetail1.setUserid(deliveryDetail.getUserid());
        deliveryDetail1.setCompany(deliveryDetail.getCompany());
        deliveryDetail1.setStreetAddress(deliveryDetail.getStreetAddress());
        deliveryDetail1.setHouseNumber(deliveryDetail.getHouseNumber());
        deliveryDetail1.setTown(deliveryDetail.getTown());
        deliveryDetail1.setZipCode(deliveryDetail.getZipCode());
        deliveryDetail1.setNotes(deliveryDetail.getNotes());

        return deliveryDetailRepository.save(deliveryDetail1);
    }

    @Override
    public DeliveryDetail updateDelivery(DeliveryDetail deliveryDetail) {
        return deliveryDetailRepository.save(deliveryDetail);
    }

    @Override
    public DeliveryDetail getDeliveryInformation(Long userId) {
        return deliveryDetailRepository.findDeliveryDetailByUserid(userId);
    }
}
