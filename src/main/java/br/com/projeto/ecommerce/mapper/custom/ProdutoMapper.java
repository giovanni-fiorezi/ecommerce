package br.com.projeto.ecommerce.mapper.custom;

import br.com.projeto.ecommerce.entity.ProdutoEntity;
//import br.com.projeto.ecommerce.vo.v2.ProdutoVOV2;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
import org.springframework.stereotype.Service;

/**
* Classe responsavel por converter Entidade em VO e vice-versa
*/

@Service
public class ProdutoMapper {

    public ProdutoVO convertEntityToVo(ProdutoEntity entity) {
        ProdutoVO vov2 = new ProdutoVO();
        vov2.setKey(entity.getId());
        vov2.setName(entity.getName());
        vov2.setCategoria(entity.getCategoria());
        vov2.setPreco(entity.getPreco());
        vov2.setDescricao(entity.getDescricao());
        return vov2;
    }

    public ProdutoEntity convertVoToEntity(ProdutoVO vov2) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(vov2.getKey());
        entity.setName(vov2.getName());
        entity.setCategoria(vov2.getCategoria());
        entity.setPreco(vov2.getPreco());
        entity.setDescricao(vov2.getDescricao());
        return entity;
    }

}
