package br.com.projeto.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pagamento_cartao")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoCartaoEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum status;

    private String numero;
}
