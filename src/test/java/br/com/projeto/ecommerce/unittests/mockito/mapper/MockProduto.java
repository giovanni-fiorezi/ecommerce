package br.com.projeto.ecommerce.unittests.mockito.mapper;

import br.com.projeto.ecommerce.entity.ProdutoEntity;
import br.com.projeto.ecommerce.enums.CategoriaEnum;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MockProduto {

    public ProdutoEntity mockEntity() {
        return mockEntity(0);
    }

    public ProdutoVO mockVO() {
        return mockVO(0);
    }

    public List<ProdutoEntity> mockEntityList() {
        List<ProdutoEntity> produtos = new ArrayList<ProdutoEntity>();
        for (int i = 0; i < 14; i++) {
            produtos.add(mockEntity(i));
        }
        return produtos;
    }

    public List<ProdutoVO> mockVOList() {
        List<ProdutoVO> produtos = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            produtos.add(mockVO(i));
        }
        return produtos;
    }

    public ProdutoEntity mockEntity(Integer number) {
        ProdutoEntity produto = new ProdutoEntity();
        produto.setName("name" + number);
        produto.setDescricao("descrição" + number);
        produto.setCategoria(CategoriaEnum.ELETRONICO);
        produto.setId(number.longValue());
        produto.setPreco(new BigDecimal("3.00"));
        return produto;
    }

    public ProdutoVO mockVO(Integer number) {
        ProdutoVO vo = new ProdutoVO();
        vo.setName("name" + number);
        vo.setDescricao("descrição" + number);
        vo.setCategoria(CategoriaEnum.ELETRONICO);
        vo.setKey(number.longValue());
        vo.setPreco(new BigDecimal("3.00"));
        return vo;
    }
}
