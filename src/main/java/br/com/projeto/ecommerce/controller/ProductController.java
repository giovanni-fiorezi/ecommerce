package br.com.projeto.ecommerce.controller;

import br.com.projeto.ecommerce.dto.ProductDto;
import br.com.projeto.ecommerce.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable(value="id") Integer id){
        ProductDto productDto = productService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        ProductDto product = productService.insert(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto, @PathVariable Integer id){
        ProductDto product = productService.update(productDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }

}