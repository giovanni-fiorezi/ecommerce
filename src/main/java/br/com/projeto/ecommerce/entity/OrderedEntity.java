package br.com.projeto.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordered")
public class OrderedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderedNumber;

    private BigDecimal valueOrdered;

    private LocalDateTime dateOrdered;
    
    private List<OrderedItem> itens;
    
	public OrderedEntity() {
	}

	public OrderedEntity(Integer orderedNumber, BigDecimal valueOrdered, LocalDateTime dateOrdered) {
		super();
		this.orderedNumber = orderedNumber;
		this.valueOrdered = valueOrdered;
		this.dateOrdered = dateOrdered;
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

	

}

