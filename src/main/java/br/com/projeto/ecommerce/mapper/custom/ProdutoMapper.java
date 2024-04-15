package br.com.projeto.ecommerce.mapper.custom;

import br.com.projeto.ecommerce.entity.ProdutoEntity;
import br.com.projeto.ecommerce.vo.v2.ProdutoVOV2;
import org.springframework.stereotype.Service;

/**
* Classe responsavel por converter Entidade em VO e vice-versa
*/

@Service
public class ProdutoMapper {

    public ProdutoVOV2 convertEntityToVo(ProdutoEntity entity) {
        ProdutoVOV2 vov2 = new ProdutoVOV2();
        vov2.setId(entity.getId());
        vov2.setName(entity.getName());
        vov2.setCategoria(entity.getCategoria());
        vov2.setPreco(entity.getPreco());
        vov2.setDescricao(entity.getDescricao());
        vov2.setQuantidade(entity.getQuantidade());
        return vov2;
    }

    public ProdutoEntity convertVoToEntity(ProdutoVOV2 vov2) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(vov2.getId());
        entity.setName(vov2.getName());
        entity.setCategoria(vov2.getCategoria());
        entity.setPreco(vov2.getPreco());
        entity.setDescricao(vov2.getDescricao());
        entity.setQuantidade(vov2.getQuantidade());
        return entity;
    }

}
