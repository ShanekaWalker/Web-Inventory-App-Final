package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PurchaseController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @PostMapping("/Buy Now")
    public String BuyNow(@RequestParam("productID") int theId){
        Optional<Product> product = productRepository.findById((long) theId);
        
        Product theProduct = product.get();
        if (theProduct.getInv() != 0){
            int decrementInv = (theProduct.getInv() - 1);
            theProduct.setInv(decrementInv);
            productRepository.save(theProduct);
            return "purchaseConfirmation";
        } else return "purchaseError";
    }
}
