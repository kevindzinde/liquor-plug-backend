package zw.tinkevtechnologies.liquorplugbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import zw.tinkevtechnologies.liquorplugbackend.model.PurchaseHistory;
import zw.tinkevtechnologies.liquorplugbackend.security.UserPrincipal;
import zw.tinkevtechnologies.liquorplugbackend.service.api.PurchaseHistoryService;

@RestController
@RequestMapping("/api/purchase-history")
public class PurchaseHistoryResource {
    @Autowired
    private PurchaseHistoryService purchaseHistoryService;
    @PostMapping("/save")
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseHistoryService.findPurchaseItemsOfUser(userPrincipal.getId()));

    }

}
