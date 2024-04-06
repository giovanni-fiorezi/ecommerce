package br.com.projeto.ecommerce.service;


import br.com.projeto.ecommerce.entity.ProdutoEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class ProdutoService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(ProdutoService.class.getName());

    public List<ProdutoEntity> findAll() {
        logger.info("Buscando produtos.");

        List<ProdutoEntity> products = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ProdutoEntity product = mockProduct(i);
            products.add(product);
        }
        return products;
    }

    public ProdutoEntity findById(String id) {
        logger.info("Buscando um produto : " + id);

        ProdutoEntity product = new ProdutoEntity();
        product.setId(counter.incrementAndGet());
        product.setName("Iphone");
        product.setDescricao("Smartphone");
        product.setPreco(new BigDecimal("7800.00"));
        return product;
    }

    public ProdutoEntity create(ProdutoEntity produto) {
        logger.info("Criando um produto");
        return produto;
    }

    public ProdutoEntity update(ProdutoEntity produto) {
        logger.info("Atualizando um produto");
        return produto;
    }

    private ProdutoEntity mockProduct(int i) {
        ProdutoEntity product = new ProdutoEntity();
        product.setId(counter.incrementAndGet());
        product.setName("Product " + i);
        product.setDescricao("Smartphone " + i);
        product.setPreco(new BigDecimal("0" + i));
        return product;
    }
}
