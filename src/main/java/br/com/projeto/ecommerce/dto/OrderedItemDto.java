package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.projeto.ecommerce.entity.OrderedEntity;
import br.com.projeto.ecommerce.entity.ProductEntity;

public class OrderedItemDto {

    private Integer id;

    private BigDecimal valueItem;

    private OrderedDto ordered;

    private ProductEntity product;

    private Integer quantityItem;
    
}