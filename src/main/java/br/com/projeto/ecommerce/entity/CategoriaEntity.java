package br.com.projeto.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<ProductEntity> produtos;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private CategoriaEntity categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<CategoriaEntity> categorias;
}
