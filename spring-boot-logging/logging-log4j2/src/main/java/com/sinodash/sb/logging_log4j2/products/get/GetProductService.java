package com.sinodash.sb.logging_log4j2.products.get;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
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
