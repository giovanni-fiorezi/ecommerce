package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.entity.OrderedEntity;

public class OrderedEntityConverter {

    public static OrderedEntity fromDto(OrderedDto orderedDto){
        return OrderedEntity.builder()
                .orderedNumber(orderedDto.getOrderedNumber())
                .valueOrdered(orderedDto.getValueOrdered())
                .build();
    }
}
