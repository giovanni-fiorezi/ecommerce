package br.com.projeto.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private PedidoEntity pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private ProductEntity produto;

	private BigDecimal precoProduto;

	private Integer quantidade;

}