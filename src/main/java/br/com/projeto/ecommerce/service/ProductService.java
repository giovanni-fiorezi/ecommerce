package br.com.projeto.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ProductDto findProductById(Integer id){
        Optional<ProductEntity> entity = productRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ProductNotRegisteredException("Produto nao foi cadastrado");
        }
        return ProductDtoConverter.fromEntity(entity.get());
    }
    
    public ProductDto findByName(String name) {
    	ProductEntity nameEntity = productRepository.getByName(name);
    	if(nameEntity == null) {
    		throw new ProductException("produto nao encontrado");
    	}
    	return ProductDtoConverter.fromEntity(nameEntity);
    }

    public List<ProductDto> findAll() {
        try {
            List<ProductEntity> listAll = productRepository.findAll();
            return listAll.stream().map(product -> ProductDtoConverter.fromEntity(product))
                    .collect(Collectors.toList());
        }catch(ProductException e){
            throw new ProductException("Ocorreu um erro");
        }
    }

    public ProductDto insert(ProductDto product){
        if(productRepository.existsByName(product.getName())){
            throw new ProductInsertException("Produto já cadastrado");
        }
        ProductEntity productEntity = ProductEntityConverter.fromDto(product);
        ProductEntity entity = productRepository.save(productEntity);
        return ProductDtoConverter.fromEntity(entity);
    }

    public ProductDto update(ProductDto productDto, Integer id){
        Optional<ProductEntity> entityOptional = this.productRepository.findById(id);
        if(entityOptional.isEmpty()){
            throw new ProductException("Produto não foi encontrado");
        }
        ProductEntity productEntity = ProductEntityConverter.fromDto(productDto);
        ProductEntity entity = productRepository.save(productEntity);
        return ProductDtoConverter.fromEntity(entity);
    }

    public void delete(Integer id){
        if(!productRepository.existsById(id)){
            throw new ProductException("Produto não encontrado");
        }
        this.productRepository.deleteById(id);
    }

}
