package com.sinodash.sb.logging_log4j2.products.get;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class GetProductController {
    private final IGetProductService getProductService;

    public GetProductController(IGetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getProductByName(@RequestParam("name") String name) {
        String productDetails = getProductService.getProductByName(name);
        if (productDetails == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.ok(productDetails);
    }
}
