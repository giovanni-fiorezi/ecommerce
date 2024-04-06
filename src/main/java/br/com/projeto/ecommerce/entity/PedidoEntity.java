package br.com.projeto.ecommerce.entity;

import br.com.projeto.ecommerce.enums.FormaPagamentoEnum;
import br.com.projeto.ecommerce.enums.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

	private BigDecimal total;

	@Enumerated(EnumType.STRING)
	private StatusPedidoEnum status;

	@ManyToOne
	private ClienteEntity cliente;

	@OneToOne
	private NotaFiscalEntity notaFiscal;

	@Embedded
	private EnderecoEntregaPedido enderecoEntrega;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedidoEntity> itensPedido;

	private FormaPagamentoEnum formaPagamento;

}
