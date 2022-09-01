package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.projeto.ecommerce.entity.OrderedEntity;
import br.com.projeto.ecommerce.entity.OrderedItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.OneToMany;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;

    private String brand;

    private String productType;

    private BigDecimal unitPrice;

    private BigDecimal unitCost;

    private String desc;

    private Integer quantity;

    private LocalDateTime insertProductDate = LocalDateTime.now();
}
