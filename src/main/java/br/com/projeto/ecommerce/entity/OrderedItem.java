package br.com.projeto.ecommerce.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_item")
public class OrderedItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private Integer quantityProducts;

    private BigDecimal valueItem;

    /* um item so pode estar relacionado a um produto */
    @OneToOne
    private ProductEntity product;
	
    /* um item so pode estar relacionado a um pedido */
    @OneToOne
    private OrderedEntity ordered;
    
	public OrderedItem() {
	}

	public OrderedItem(Integer id, Integer quantityProducts, BigDecimal valueItem, ProductEntity product,
			OrderedEntity ordered) {
		super();
		this.id = id;
		this.quantityProducts = quantityProducts;
		this.valueItem = valueItem;
		this.product = product;
		this.ordered = ordered;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id, ordered, product, quantityProducts, valueItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedItem other = (OrderedItem) obj;
		return Objects.equals(id, other.id) && Objects.equals(ordered, other.ordered)
				&& Objects.equals(product, other.product) && Objects.equals(quantityProducts, other.quantityProducts)
				&& Objects.equals(valueItem, other.valueItem);
	}

	@Override
	public String toString() {
		return "OrderedItem [id=" + id + ", quantityProducts=" + quantityProducts + ", valueItem=" + valueItem
				+ ", product=" + product + ", ordered=" + ordered + "]";
	}
    
}