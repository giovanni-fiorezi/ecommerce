package br.com.projeto.ecommerce.service;


import br.com.projeto.ecommerce.entity.ProdutoEntity;
import br.com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import br.com.projeto.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProdutoService {

    private Logger logger = Logger.getLogger(ProdutoService.class.getName());

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoEntity> findAll() {
        logger.info("Bucando todos os produtos.");
        return repository.findAll();
    }

    public ProdutoEntity findById(Long id) {
        logger.info("Buscando um produto.");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com esse id: " + id));
    }

    public ProdutoEntity create(ProdutoEntity produto) {
        logger.info("Inserindo um produto");

        return repository.save(produto);
    }

    public ProdutoEntity update(ProdutoEntity produto) {
        logger.info("Atualizando um produto.");

        //Aqui eu pego o id do produto que estou passando
        Long produtoId = produto.getId();

        //Verifica se o id que eu passei consta no banco
        ProdutoEntity produtoIdExists = findById(produtoId);

        //
        if(produtoId != null && produtoIdExists != null) {
            return repository.save(produto);
        } else {
            throw new ResourceNotFoundException(String.format("Id %d não existe", produtoId));
        }
    }


}
