package br.com.projeto.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.converter.OrderedDtoConverter;
import br.com.projeto.ecommerce.converter.OrderedEntityConverter;
import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.entity.OrderedEntity;
import br.com.projeto.ecommerce.exception.EcommerceException;
import br.com.projeto.ecommerce.exception.ProductException;
import br.com.projeto.ecommerce.repository.OrderedRepository;

@Service
public class OrderedService {

    @Autowired
    private OrderedRepository orderedRepository;

    private Logger log = LoggerFactory.getLogger(OrderedService.class);

    public OrderedDto findByOrderedNumber(Integer orderedNumber){
        log.info("Buscando pedido pelo numero {}", orderedNumber);
        try {
            Optional<OrderedEntity> entityOptional = this.orderedRepository.findByOrderedNumber(orderedNumber);
            if (entityOptional.isEmpty()) {
                throw new ProductException("Numero do pedido não foi encontrado");
            }
            return OrderedDtoConverter.fromEntity(entityOptional.get());
        }catch (Exception e){
            throw new EcommerceException("Ocorreu um erro");
        }
    }

    /*filtrar pedidos por data*/
    public List<OrderedDto> findByDate(LocalDateTime dateOrdered){
        log.info("Filtrando pedidos pela data {}", dateOrdered);
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
        log.info("Inserindo um novo pedido");
        try {
            if (this.orderedRepository.existsById(orderedDto.getOrderedNumber())) {
                throw new EcommerceException("Pedido ja cadastrado");
            }
            OrderedEntity orderedEntity = OrderedEntityConverter.fromDto(orderedDto);
            return OrderedDtoConverter.fromEntity(this.orderedRepository.save(orderedEntity));
        }catch (Exception e){
            throw new EcommerceException("Ocorreu um erro");
        }
    }

    public void update(OrderedDto orderedDto, Integer orderedNumber){
        log.info("Atualizando um pedido");
        try{
            this.orderedRepository.findByOrderedNumber(orderedNumber).ifPresentOrElse((orderedEntity) -> {
                orderedRepository.save(OrderedEntityConverter.fromDto(orderedDto));
            }, () -> {
                throw new EcommerceException("Pedido nao encontrado");
            });
        } catch(Exception e){
            throw new EcommerceException("Ocorreu um erro");
        }
    }

    public void deleteOrdered(Integer orderedNumber) {
        log.info("Deletando um pedido");
        try {
            if (!orderedRepository.existsById(orderedNumber)) {
                throw new EcommerceException("Pedido nao encontrado");
            }
            orderedRepository.deleteById(orderedNumber);
        }catch (Exception e){
            throw new EcommerceException("Ocorreu um erro");
        }
    }
}