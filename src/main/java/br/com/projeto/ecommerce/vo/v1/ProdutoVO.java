package br.com.projeto.ecommerce.vo.v1;

import br.com.projeto.ecommerce.enums.CategoriaEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@JsonPropertyOrder({"id", "name", "descricao", "preco", "categoria"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {

    private static final long serialVersionUID = -622825531509422678L;

    @JsonProperty(value = "id")
    private Long key;
    private String name;
    private String descricao;
    private BigDecimal preco;
    private CategoriaEnum categoria;

}
