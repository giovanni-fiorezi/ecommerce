package br.com.projeto.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.apache.tomcat.jni.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String brand;

    private String productType;

    private BigDecimal unitPrice;

    private BigDecimal unitCost;

    @Column(name = "description_product")
    private String desc;
    
    private Integer quantity;

    @OneToMany(mappedBy = "product")
    private List<OrderedItem> itens;
    
    @Column(name = "insert_product_date")
    private LocalDateTime insertProductDate = LocalDateTime.now();

}