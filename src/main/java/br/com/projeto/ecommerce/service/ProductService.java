package br.com.projeto.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.projeto.ecommerce.exception.EcommerceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.converter.ProductDtoConverter;
import br.com.projeto.ecommerce.converter.ProductEntityConverter;
import br.com.projeto.ecommerce.dto.ProductDto;
import br.com.projeto.ecommerce.entity.ProductEntity;
import br.com.projeto.ecommerce.exception.ProductException;
import br.com.projeto.ecommerce.exception.ProductInsertException;
import br.com.projeto.ecommerce.exception.ProductNotRegisteredException;
import br.com.projeto.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductDto findProductById(Integer id){
        log.info("Buscando produto pelo id {}", id);
        Optional<ProductEntity> entity = productRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ProductNotRegisteredException("Produto nao foi cadastrado");
        }
        return ProductDtoConverter.fromEntity(entity.get());
    }

    public ProductDto findByName(String name) {
        log.info("Buscando um produto pelo nome {}", name);
    	ProductEntity nameEntity = productRepository.getByName(name);
    	if(nameEntity == null) {
    		throw new ProductException("produto nao encontrado");
    	}
    	return ProductDtoConverter.fromEntity(nameEntity);
    }

    public List<ProductDto> findAll() {
        log.info("Buscando todos os produtos");
        try {
            List<ProductEntity> listAll = productRepository.findAll();
            return listAll.stream().map(product -> ProductDtoConverter.fromEntity(product))
                    .collect(Collectors.toList());
        }catch(ProductException e){
            throw new ProductException("Ocorreu um erro");
        }
    }

    public ProductDto insert(ProductDto product){
        log.info("Cadastrando um novo produto");
        if(productRepository.existsByName(product.getName())){
            throw new ProductInsertException("Produto já cadastrado");
        }
        ProductEntity productEntity = ProductEntityConverter.fromDto(product);
        ProductEntity entity = productRepository.save(productEntity);
        return ProductDtoConverter.fromEntity(entity);
    }

    public ProductDto update(ProductDto productDto, Integer id){
        log.info("Atualizando um produto");
        try {
            Optional<ProductEntity> entityOptional = this.productRepository.findById(id);
            if (entityOptional.isEmpty()) {
                throw new ProductException("Produto não foi encontrado");
            } else {
                return ProductDtoConverter.fromEntity(productRepository.save(ProductEntityConverter.fromDto(productDto)));
            }
        }catch (Exception e){
            throw  new EcommerceException("Erro ao atualizar o produto");
        }
    }

    public void delete(Integer id){
        log.info("Deletando um produto");
        if(!productRepository.existsById(id)){
            throw new ProductException("Produto não encontrado");
        }
        this.productRepository.deleteById(id);
    }

}
