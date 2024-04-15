package br.com.projeto.ecommerce.resource;

import br.com.projeto.ecommerce.service.ProdutoService;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
import br.com.projeto.ecommerce.vo.v2.ProdutoVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
public class ProdutoResource {

    @Autowired
    private ProdutoService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProdutoVO> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoVO findById(@PathVariable(value="id") Long id) {
        return productService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoVO create(@RequestBody ProdutoVO produto) {
        return productService.create(produto);
    }

    /* Criado para treinar e testar versionamento */
    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoVOV2 createV2(@RequestBody ProdutoVOV2 produto) {
        return productService.createV2(produto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoVO update(@RequestBody ProdutoVO produto) {
        return productService.update(produto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
