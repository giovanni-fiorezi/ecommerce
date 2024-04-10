package br.com.projeto.ecommerce.enums;


public enum CategoriaEnum {

    ELETRONICO("Eletrônico"),
    ROUPAS("Roupas")
    ;

    private String descricao;

    CategoriaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
