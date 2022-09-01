package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.projeto.ecommerce.entity.OrderedItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.OneToMany;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderedDto {

    private Integer orderedNumber;

    private BigDecimal valueOrdered;

//    private LocalDateTime dateOrdered = LocalDateTime.now();

    private List<OrderedItemDto> itens;

}
