package br.com.projeto.ecommerce.resource;

import br.com.projeto.ecommerce.entity.ProdutoEntity;
import br.com.projeto.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProdutoResource {

    @Autowired
    private ProdutoService productService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProdutoEntity> findAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoEntity findById(@PathVariable(value="id") String id) {
        return productService.findById(id);
    }

    @RequestMapping( method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoEntity create(@RequestBody ProdutoEntity produto) {
        return productService.create(produto);
    }

    @RequestMapping(method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoEntity update(@RequestBody ProdutoEntity produto) {
        return productService.update(produto);
    }

}
