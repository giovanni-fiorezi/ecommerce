package br.com.projeto.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer produtoId;

    private Integer quantidade;
}
