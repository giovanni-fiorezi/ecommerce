package br.com.projeto.ecommerce.vo.v1;

import br.com.projeto.ecommerce.enums.CategoriaEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProdutoVO implements Serializable {

    private static final long serialVersionUID = -622825531509422678L;

    private Long id;
    private String name;
    private String descricao;
    private BigDecimal preco;
    private CategoriaEnum categoria;

}
