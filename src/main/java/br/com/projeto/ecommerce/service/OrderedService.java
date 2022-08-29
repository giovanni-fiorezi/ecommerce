package br.com.projeto.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.converter.OrderedDtoConverter;
import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.entity.OrderedEntity;
import br.com.projeto.ecommerce.exception.EcommerceException;
import br.com.projeto.ecommerce.exception.ProductException;
import br.com.projeto.ecommerce.repository.OrderedRepository;

@Service
public class OrderedService {

    @Autowired
    private OrderedRepository orderedRepository;

    public OrderedDto findByOrderedNumber(Integer orderedNumber){
        Optional<OrderedEntity> entityOptional = this.orderedRepository.findByOrderedNumber(orderedNumber);
        if(entityOptional.isEmpty()){
            throw new ProductException("Numero do pedido não foi encontrado");
        }
        return OrderedDtoConverter.fromEntity(entityOptional.get());
    }
    
    public void deleteOrdered(Integer orderedNumber) {
    	if(!orderedRepository.existsById(orderedNumber)) {
    		throw new EcommerceException("Pedido nao encontrado");
    	}
    	orderedRepository.deleteById(orderedNumber);
    }
}
