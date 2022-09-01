package br.com.projeto.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "ordered_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private BigDecimal valueItem;

	@OneToOne
	@JoinColumn(name = "ordered_number")
	private OrderedEntity ordered;

	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	private Integer quantityItem;

}