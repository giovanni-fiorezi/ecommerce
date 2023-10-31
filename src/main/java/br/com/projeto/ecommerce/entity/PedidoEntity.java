package br.com.projeto.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private LocalDateTime dataPedido;

	private LocalDateTime dataConclusao;

	private Integer notaFiscalId;

	private BigDecimal total;

	@Enumerated(EnumType.STRING)
	private StatusPedidoEnum status;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteEntity cliente;

	@Embedded
	private EnderecoEntregaPedido enderecoEntrega;

}
