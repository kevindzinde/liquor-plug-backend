package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.tinkevtechnologies.liquorplugbackend.model.DeliveryDetail;

public interface DeliveryDetailRepository extends JpaRepository<DeliveryDetail,Long> {
    DeliveryDetail findDeliveryDetailByUserid(Long userid);
}
