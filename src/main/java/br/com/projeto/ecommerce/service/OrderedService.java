package br.com.projeto.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.projeto.ecommerce.converter.OrderedEntityConverter;
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

    /*filtrar pedidos por data*/
    public List<OrderedDto> findByDate(LocalDateTime dateOrdered){
        try {
            List<OrderedEntity> orderedList = this.orderedRepository.findByDateOrdered(dateOrdered);
            return orderedList
                    .stream()
                    .map(ordered -> OrderedDtoConverter.fromEntity(ordered))
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new EcommerceException("Ocorreu um erro na busca");
        }
    }

    public OrderedDto insert(OrderedDto orderedDto){
        if(this.orderedRepository.existsById(orderedDto.getOrderedNumber())){
            throw new EcommerceException("Pedido ja cadastrado");
        }
        OrderedEntity orderedEntity = OrderedEntityConverter.fromDto(orderedDto);
        return OrderedDtoConverter.fromEntity(this.orderedRepository.save(orderedEntity));
    }

    public OrderedDto update(OrderedDto orderedDto, Integer orderedNumber){
        try{
            Optional<OrderedEntity> optional = this.orderedRepository.findByOrderedNumber(orderedNumber);
            if(optional.isEmpty()){
                throw new EcommerceException("Pedido nao encontrado");
            }
            OrderedEntity entity = OrderedEntityConverter.fromDto(orderedDto);
            return OrderedDtoConverter.fromEntity(this.orderedRepository.save(entity));
        } catch(Exception e){
            throw new EcommerceException("Pedido nao encontrado");
        }
    }

    public void deleteOrdered(Integer orderedNumber) {
    	if(!orderedRepository.existsById(orderedNumber)) {
    		throw new EcommerceException("Pedido nao encontrado");
    	}
    	orderedRepository.deleteById(orderedNumber);
    }
}
