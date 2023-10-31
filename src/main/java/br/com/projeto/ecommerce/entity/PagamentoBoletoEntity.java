package br.com.projeto.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pagamento_boleto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoBoletoEntity {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum status;

    private String codigoBarras;
}
