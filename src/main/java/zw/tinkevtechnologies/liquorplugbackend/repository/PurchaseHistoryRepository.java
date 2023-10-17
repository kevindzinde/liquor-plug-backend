package zw.tinkevtechnologies.liquorplugbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.tinkevtechnologies.liquorplugbackend.model.Product;
import zw.tinkevtechnologies.liquorplugbackend.model.PurchaseHistory;
import zw.tinkevtechnologies.liquorplugbackend.model.User;

import java.util.List;

public interface PurchaseHistoryRepository  extends JpaRepository<PurchaseHistory,Long> {

   User findByUserId(Long id);
   List<PurchaseHistory> findAllByUserId(Long id);
}
