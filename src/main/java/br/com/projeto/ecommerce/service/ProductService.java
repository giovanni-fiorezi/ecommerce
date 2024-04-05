package br.com.projeto.ecommerce.service;


import br.com.projeto.ecommerce.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class ProductService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(ProductService.class.getName());

    public List<ProductEntity> findAll() {
        logger.info("Buscando produtos.");

        List<ProductEntity> products = new ArrayList<>();

        return products;
    }

    public ProductEntity findById(String id) {
        logger.info("Buscando um produto : " + id);

        ProductEntity product = new ProductEntity();
        product.setId(counter.incrementAndGet());
        product.setName("Iphone");
        product.setDescricao("Smartphone");
        product.setPreco(new BigDecimal("7800.00"));

        return product;
    }
}
