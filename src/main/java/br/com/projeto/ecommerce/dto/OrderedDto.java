package br.com.projeto.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.projeto.ecommerce.entity.OrderedItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedDto {

    private Integer orderedNumber;

    private BigDecimal valueOrdered;

//    private LocalDateTime dateOrdered = LocalDateTime.now();

    private List<OrderedItemDto> itens;

}
