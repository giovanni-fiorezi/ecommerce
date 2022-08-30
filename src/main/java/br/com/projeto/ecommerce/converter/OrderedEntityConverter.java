package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.entity.OrderedEntity;

public class OrderedEntityConverter {

    public static OrderedEntity fromDto(OrderedDto orderedDto){
        OrderedEntity entity = new OrderedEntity();
        entity.setDateOrdered(orderedDto.getDateOrdered());
        entity.setOrderedNumber(orderedDto.getOrderedNumber());
        entity.setValueOrdered(orderedDto.getValueOrdered());
        entity.setItens(orderedDto.getItens());
        return entity;
    }
}
