package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.projeto.ecommerce.entity.OrderedItem;

public class OrderedDto {

	private Integer orderedNumber;

	private BigDecimal valueOrdered;

	private LocalDateTime dateOrdered;

	private List<OrderedItem> itens;

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
