package br.com.projeto.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordered")
public class OrderedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderedNumber;

	private BigDecimal valueOrdered;

	private LocalDateTime dateOrdered;

	/* um pedido pode estar relacionado a varios itens */
	@OneToMany
	private List<OrderedItem> itens;

	public OrderedEntity() {

	}

	public OrderedEntity(Integer orderedNumber, BigDecimal valueOrdered, LocalDateTime dateOrdered,
			List<OrderedItem> itens) {
		super();
		this.orderedNumber = orderedNumber;
		this.valueOrdered = valueOrdered;
		this.dateOrdered = dateOrdered;
		this.itens = itens;
	}

	public Integer getOrderedNumber() {
		return orderedNumber;
	}

	public void setOrderedNumber(Integer orderedNumber) {
		this.orderedNumber = orderedNumber;
	}

	public BigDecimal getValueOrdered() {
		return valueOrdered;
	}

	public void setValueOrdered(BigDecimal valueOrdered) {
		this.valueOrdered = valueOrdered;
	}

	public LocalDateTime getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(LocalDateTime dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public List<OrderedItem> getItens() {
		return itens;
	}

	public void setItens(List<OrderedItem> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOrdered, itens, orderedNumber, valueOrdered);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedEntity other = (OrderedEntity) obj;
		return Objects.equals(dateOrdered, other.dateOrdered) && Objects.equals(itens, other.itens)
				&& Objects.equals(orderedNumber, other.orderedNumber)
				&& Objects.equals(valueOrdered, other.valueOrdered);
	}

	@Override
	public String toString() {
		return "OrderedEntity [orderedNumber=" + orderedNumber + ", valueOrdered=" + valueOrdered + ", dateOrdered="
				+ dateOrdered + ", itens=" + itens + "]";
	}

}
