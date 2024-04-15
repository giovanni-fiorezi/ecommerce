package br.com.projeto.ecommerce.vo.v2;

import br.com.projeto.ecommerce.enums.CategoriaEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProdutoVOV2 implements Serializable {

    private static final long serialVersionUID = 7815289366548747800L;

    private Long id;
    private String name;
    private String descricao;
    private BigDecimal preco;
    private CategoriaEnum categoria;
    private Integer quantidade;
}
