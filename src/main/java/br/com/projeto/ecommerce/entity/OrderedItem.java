package br.com.projeto.ecommerce.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ordered_item")
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantityProducts;

    private BigDecimal valueItens;

    @ManyToOne
    private List<ProductEntity> product;

    @ManyToOne
    private OrderedEntity ordered;

	public OrderedItem(Integer id, Integer quantityProducts, BigDecimal valueItens, List<ProductEntity> product,
			OrderedEntity ordered) {
		super();
		this.id = id;
		this.quantityProducts = quantityProducts;
		this.valueItens = valueItens;
		this.product = product;
		this.ordered = ordered;
	}

	public OrderedItem() {
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

	public BigDecimal getValueItens() {
		return valueItens;
	}

	public void setValueItens(BigDecimal valueItens) {
		this.valueItens = valueItens;
	}

	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
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
		return Objects.hash(id, ordered, product, quantityProducts, valueItens);
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
				&& Objects.equals(valueItens, other.valueItens);
	}

	@Override
	public String toString() {
		return "OrderedItem [id=" + id + ", quantityProducts=" + quantityProducts + ", valueItens=" + valueItens
				+ ", product=" + product + ", ordered=" + ordered + "]";
	}
 
}