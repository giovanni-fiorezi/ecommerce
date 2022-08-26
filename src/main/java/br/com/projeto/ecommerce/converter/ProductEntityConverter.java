package br.com.projeto.ecommerce.converter;

import br.com.projeto.ecommerce.dto.ProductDto;
import br.com.projeto.ecommerce.entity.ProductEntity;

public class ProductEntityConverter {

    public static ProductEntity fromDto(ProductDto productDto){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setBrand(productDto.getBrand());
        productEntity.setProductType(productDto.getProductType());
        productEntity.setDesc(productDto.getDesc());
        productEntity.setUnitPrice(productDto.getUnitPrice());
        productEntity.setUnitCost(productDto.getUnitCost());
        productEntity.setInsertProductDate(productDto.getInsertProductDate());
        return productEntity;
    }
}
