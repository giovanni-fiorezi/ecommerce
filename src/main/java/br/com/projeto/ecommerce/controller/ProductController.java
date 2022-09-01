package br.com.projeto.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.dto.ProductDto;
import br.com.projeto.ecommerce.service.ProductService;

@CrossOrigin
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

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<ProductDto> findProductByName(@PathVariable(name = "name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByName(name));
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

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody ProductDto productDto){
        this.productService.update(productDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }

}