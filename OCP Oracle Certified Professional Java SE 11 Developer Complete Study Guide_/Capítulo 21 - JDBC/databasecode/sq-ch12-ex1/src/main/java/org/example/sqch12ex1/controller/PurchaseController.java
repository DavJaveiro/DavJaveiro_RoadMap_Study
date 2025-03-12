package org.example.sqch12ex1.controller;

import org.example.sqch12ex1.model.Purchase;
import org.example.sqch12ex1.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findPurchase() {
        return purchaseRepository.findAllProducts();
    }



}
