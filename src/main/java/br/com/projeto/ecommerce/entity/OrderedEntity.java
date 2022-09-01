package br.com.projeto.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ordered")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderedNumber;

	private BigDecimal valueOrdered;

	private LocalDateTime dateOrdered = LocalDateTime.now();

	@OneToMany(mappedBy = "ordered")
	private List<OrderedItem> itens;

}
