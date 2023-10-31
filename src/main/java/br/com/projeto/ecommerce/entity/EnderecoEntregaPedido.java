package br.com.projeto.ecommerce.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class EnderecoEntregaPedido {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
