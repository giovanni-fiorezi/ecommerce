package br.com.projeto.ecommerce.entity;

import br.com.projeto.ecommerce.enums.CategoriaEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7669479689311086039L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    private Integer quantidade;

}