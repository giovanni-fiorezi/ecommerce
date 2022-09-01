package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.ProductDto;
import br.com.projeto.ecommerce.entity.ProductEntity;

public class ProductDtoConverter {

    public static ProductDto fromEntity(ProductEntity productEntity){
        return ProductDto.builder()
                .name(productEntity.getName())
                .brand(productEntity.getBrand())
                .productType(productEntity.getProductType())
                .desc(productEntity.getDesc())
                .unitPrice(productEntity.getUnitPrice())
                .unitCost(productEntity.getUnitCost())
                .quantity(productEntity.getQuantity())
                .insertProductDate(productEntity.getInsertProductDate())
        .build();
    }
}
