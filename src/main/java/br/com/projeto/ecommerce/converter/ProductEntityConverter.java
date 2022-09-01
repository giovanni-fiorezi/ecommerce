package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.ProductDto;
import br.com.projeto.ecommerce.entity.ProductEntity;

public class ProductEntityConverter {

    public static ProductEntity fromDto(ProductDto productDto){
        return ProductEntity.builder()
                .name(productDto.getName())
                .brand(productDto.getBrand())
                .productType(productDto.getProductType())
                .desc(productDto.getDesc())
                .unitPrice(productDto.getUnitPrice())
                .unitCost(productDto.getUnitCost())
                .quantity(productDto.getQuantity())
                .insertProductDate(productDto.getInsertProductDate())
            .build();
    }
}
