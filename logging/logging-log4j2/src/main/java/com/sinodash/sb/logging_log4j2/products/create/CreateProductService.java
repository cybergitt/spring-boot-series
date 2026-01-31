package com.sinodash.sb.logging_log4j2.products.create;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CreateProductService implements ICreateProductService {

    @Override
    public void createProduct(String productName) {
        log.info("Starting product creation process for: {}", productName);
        try {
            log.info("Creating product: {}", productName);
            log.info("Product '{}' has been created.", productName);
        } catch (Exception e) {
            log.error("Error creating product: {}", productName, e);
        }
    }

}
