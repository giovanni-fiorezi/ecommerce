package br.com.projeto.ecommerce.service;

import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.entity.OrderedEntity;
import br.com.projeto.ecommerce.exception.ProductException;
import br.com.projeto.ecommerce.repository.OrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderedService {

    @Autowired
    private OrderedRepository orderedRepository;

    public OrderedEntity findByOrderedNumber(Integer orderedNumber){
        Optional<OrderedEntity> entityOptional = this.orderedRepository.findByOrderedNumber(orderedNumber);
        if(entityOptional.isEmpty()){
            throw new ProductException("Numero do pedido não foi encontrado");
        }
        return entityOptional.get();
    }

}
