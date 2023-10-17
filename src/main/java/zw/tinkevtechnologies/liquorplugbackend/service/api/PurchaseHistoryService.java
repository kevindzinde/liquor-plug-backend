package zw.tinkevtechnologies.liquorplugbackend.service.api;

import zw.tinkevtechnologies.liquorplugbackend.model.PurchaseHistory;

import java.util.List;

public interface PurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<PurchaseHistory> findPurchaseItemsOfUser(Long id);
}
