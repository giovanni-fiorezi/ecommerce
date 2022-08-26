package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.ProductDto;
import br.com.projeto.ecommerce.entity.ProductEntity;

public class ProductDtoConverter {

    public static ProductDto fromEntity(ProductEntity productEntity){
        ProductDto productDto = new ProductDto();
        productDto.setName(productEntity.getName());
        productDto.setProductType(productEntity.getProductType());
        productDto.setInsertProductDate(productEntity.getInsertProductDate());
        productDto.setBrand(productEntity.getBrand());
        productDto.setDesc(productEntity.getDesc());
        productDto.setUnitCost(productEntity.getUnitCost());
        productDto.setUnitPrice(productEntity.getUnitPrice());
        productDto.setItens(productEntity.getItens());
        return productDto;
    }
}
