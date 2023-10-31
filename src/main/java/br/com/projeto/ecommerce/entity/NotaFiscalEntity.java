package br.com.projeto.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nota_fiscal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscalEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pedidoId;

    private String xml;

    private Date dataEmissao;
}
