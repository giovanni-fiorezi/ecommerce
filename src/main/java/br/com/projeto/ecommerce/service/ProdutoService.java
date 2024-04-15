package br.com.projeto.ecommerce.service;

import br.com.projeto.ecommerce.entity.ProdutoEntity;
import br.com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import br.com.projeto.ecommerce.mapper.ModelMapper;
import br.com.projeto.ecommerce.mapper.custom.ProdutoMapper;
import br.com.projeto.ecommerce.repository.ProdutoRepository;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
import br.com.projeto.ecommerce.vo.v2.ProdutoVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProdutoService {

    private Logger logger = Logger.getLogger(ProdutoService.class.getName());

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper produtoMapper;

    public List<ProdutoVO> findAll() {
        logger.info("Bucando todos os produtos.");
        return ModelMapper.parseListObjects(repository.findAll(), ProdutoVO.class);
    }

    public ProdutoVO findById(Long id) {
        logger.info("Buscando um produto.");

        ProdutoEntity produtoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com esse id: " + id));

        return ModelMapper.parseObject(produtoEntity, ProdutoVO.class);
    }

    public ProdutoVO create(ProdutoVO produto) {
        logger.info("Inserindo um produto");

        ProdutoEntity produtoEntity = ModelMapper.parseObject(produto, ProdutoEntity.class);
        ProdutoEntity produtoSave = repository.save(produtoEntity);
        return ModelMapper.parseObject(produtoSave, ProdutoVO.class);
    }

    /* Método criado para aprender sobre versionamento */
    public ProdutoVOV2 createV2(ProdutoVOV2 produto) {
        logger.info("Inserindo um produto");

        // Convertendo um vo em uma entidade
        ProdutoEntity produtoEntity = produtoMapper.convertVoToEntity(produto);

        // Salvando a entidade no banco
        ProdutoEntity produtoSave = repository.save(produtoEntity);

        // Convertendo a entidade em vo para retornar no método
        return produtoMapper.convertEntityToVo(produtoSave);
    }

    public ProdutoVO update(ProdutoVO produto) {
        logger.info("Atualizando um produto.");

        //Aqui eu pego o id do produto que estou passando
        Long produtoId = produto.getId();

        //Verifica se o id que eu passei consta no banco
        ProdutoEntity produtoEntity = repository.findById(produtoId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Id %d não existe", produtoId)));

        //Salvando a entidade no banco
        ProdutoEntity produtoSave = repository.save(produtoEntity);
        return ModelMapper.parseObject(produtoSave, ProdutoVO.class);
    }

    public void delete(Long id) {
        logger.info("Deletando um produto.");

        //Verifico se existe esse id passado no Banco, caso não exista lança a exceção
        ProdutoEntity produtoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Id %d não existe", id)));

        repository.delete(produtoEntity);
    }

}
