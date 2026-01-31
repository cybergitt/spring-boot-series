package com.sinodash.sb.logging_log4j2.products.create;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/products")
public class CreateProductController {
    private final ICreateProductService createProductService;

    public CreateProductController(ICreateProductService createProductService) {
        this.createProductService = createProductService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody String productName) {
        createProductService.createProduct(productName);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product creation initiated for: " + productName);
    }
}
