package zw.tinkevtechnologies.liquorplugbackend.service.impl;

import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.PurchaseHistory;
import zw.tinkevtechnologies.liquorplugbackend.repository.PurchaseHistoryRepository;
import zw.tinkevtechnologies.liquorplugbackend.service.api.PurchaseHistoryService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    private PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryServiceImpl(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setPurchasetime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);

    }
    @Override
    public List<PurchaseHistory> findPurchaseItemsOfUser(Long id){
        return purchaseHistoryRepository.findAllByUserId(id);
    }
}
