package br.com.projeto.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projeto.ecommerce.entity.ProductEntity;
import br.com.projeto.ecommerce.service.UploadFileProducts;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class FileProductsController {

    @Autowired
    private UploadFileProducts uploadFileProducts;

    @PostMapping
    public ResponseEntity<List<ProductEntity>> upload(@RequestParam("doc")MultipartFile doc) throws IOException {
        return ResponseEntity.ok(this.uploadFileProducts.uploadFile(doc));
    }
}
