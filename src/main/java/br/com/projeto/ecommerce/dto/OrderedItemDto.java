package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.OneToOne;

import br.com.projeto.ecommerce.entity.OrderedEntity;
import br.com.projeto.ecommerce.entity.ProductEntity;

public class OrderedItemDto {

	private Integer id;

    private Integer quantityProducts;

    private BigDecimal valueItem;
    
    private ProductEntity product;
    
    private OrderedEntity ordered;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantityProducts() {
		return quantityProducts;
	}

	public void setQuantityProducts(Integer quantityProducts) {
		this.quantityProducts = quantityProducts;
	}

	public BigDecimal getValueItem() {
		return valueItem;
	}

	public void setValueItem(BigDecimal valueItem) {
		this.valueItem = valueItem;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public OrderedEntity getOrdered() {
		return ordered;
	}

	public void setOrdered(OrderedEntity ordered) {
		this.ordered = ordered;
	}
    
    
    
}