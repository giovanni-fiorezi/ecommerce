package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.entity.OrderedEntity;

public class OrderedDtoConverter {

	public static OrderedDto fromEntity(OrderedEntity entity) {
		 return OrderedDto.builder()
                 .orderedNumber(entity.getOrderedNumber())
                 .valueOrdered(entity.getValueOrdered())
                .build();
	}

}
