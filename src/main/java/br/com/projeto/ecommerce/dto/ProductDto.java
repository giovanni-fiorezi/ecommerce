package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.projeto.ecommerce.entity.OrderedEntity;
import br.com.projeto.ecommerce.entity.OrderedItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.OneToMany;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    @NotNull
    private Integer id;

    private String name;

    private String brand;

    private String productType;

    private BigDecimal unitPrice;

    private BigDecimal unitCost;

    private String desc;

    private Integer quantity;

    private LocalDateTime insertProductDate = LocalDateTime.now();
}
