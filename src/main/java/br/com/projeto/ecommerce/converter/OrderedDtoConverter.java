package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.entity.OrderedEntity;

public class OrderedDtoConverter {
	
	public static OrderedDto fromEntity(OrderedEntity entity) {
		OrderedDto orderedDto = new OrderedDto();
		orderedDto.setOrderedNumber(entity.getOrderedNumber());
		orderedDto.setValueOrdered(entity.getValueOrdered());
		orderedDto.setDateOrdered(entity.getDateOrdered());
		orderedDto.setItens(entity.getItens());
		return orderedDto;
	}

}
