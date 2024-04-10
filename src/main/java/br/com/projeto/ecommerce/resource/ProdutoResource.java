package br.com.projeto.ecommerce.resource;

import br.com.projeto.ecommerce.service.ProdutoService;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
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
