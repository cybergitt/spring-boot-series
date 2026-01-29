package com.sinodash.sb.logging_default.products.get;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetProductService implements IGetProductService {

    @Override
    public String getProductByName(String productName) {
        log.info("Fetching product details for: {}", productName);
        try {
            log.info("Product '{}' found.", productName);
            return productName;
        } catch (Exception e) {
            log.error("Error fetching product: {}", productName, e);
            return null;
        }
    }

}
