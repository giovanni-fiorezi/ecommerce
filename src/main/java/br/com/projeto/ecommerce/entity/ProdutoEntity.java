package br.com.projeto.ecommerce.entity;

import lombok.*;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table (name = "produto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;
    private BigDecimal preco;

//    @ManyToMany
//    @JoinTable(name = "produto_categoria",
//            joinColumns = @JoinColumn(name = "produto_id"),
//            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
//    private List<CategoriaEnum> categorias;
}