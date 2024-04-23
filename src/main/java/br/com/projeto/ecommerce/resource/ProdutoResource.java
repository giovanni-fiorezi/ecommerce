package br.com.projeto.ecommerce.resource;

import br.com.projeto.ecommerce.enums.CategoriaEnum;
import br.com.projeto.ecommerce.service.ProdutoService;
import br.com.projeto.ecommerce.util.MediaType;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
public class ProdutoResource {

    @Autowired
    private ProdutoService productService;

    @GetMapping(produces = {
            MediaType.MEDIA_TYPE_APPLICATION_JSON,
            MediaType.MEDIA_TYPE_APPLICATION_YML,
            MediaType.MEDIA_TYPE_APPLICATION_XML })
    public List<ProdutoVO> findAll() {
        return productService.findAll();
}

    @GetMapping(value = "/find-by-categoria",
            produces = {
                    MediaType.MEDIA_TYPE_APPLICATION_JSON,
                    MediaType.MEDIA_TYPE_APPLICATION_YML,
                    MediaType.MEDIA_TYPE_APPLICATION_XML })
    public List<ProdutoVO> findByCategoria(@RequestParam(value = "categoria") CategoriaEnum categoria){
        return productService.findByCategoria(categoria);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.MEDIA_TYPE_APPLICATION_JSON, MediaType.MEDIA_TYPE_APPLICATION_YML, MediaType.MEDIA_TYPE_APPLICATION_XML })
    public ProdutoVO findById(@PathVariable(value="id") Long id) {
        return productService.findById(id);
    }

    @PostMapping(produces = {
            MediaType.MEDIA_TYPE_APPLICATION_JSON,
            MediaType.MEDIA_TYPE_APPLICATION_YML,
            MediaType.MEDIA_TYPE_APPLICATION_XML },
            consumes = { MediaType.MEDIA_TYPE_APPLICATION_JSON, MediaType.MEDIA_TYPE_APPLICATION_YML, MediaType.MEDIA_TYPE_APPLICATION_XML })
    public ProdutoVO create(@RequestBody ProdutoVO produto) {
        return productService.create(produto);
    }

    /* Criado para treinar e testar versionamento */
//    @PostMapping(value = "/v2", produces = { MediaType.MEDIA_TYPE_APPLICATION_JSON, MediaType.MEDIA_TYPE_APPLICATION_YML, MediaType.MEDIA_TYPE_APPLICATION_XML },
//            consumes = { MediaType.MEDIA_TYPE_APPLICATION_JSON, MediaType.MEDIA_TYPE_APPLICATION_YML, MediaType.MEDIA_TYPE_APPLICATION_XML })
//    public ProdutoVOV2 createV2(@RequestBody ProdutoVOV2 produto) {
//        return productService.createV2(produto);
//    }

    @PutMapping(produces = {
            MediaType.MEDIA_TYPE_APPLICATION_JSON,
            MediaType.MEDIA_TYPE_APPLICATION_YML,
            MediaType.MEDIA_TYPE_APPLICATION_XML },
            consumes = { MediaType.MEDIA_TYPE_APPLICATION_JSON, MediaType.MEDIA_TYPE_APPLICATION_YML, MediaType.MEDIA_TYPE_APPLICATION_XML })
    public ProdutoVO update(@RequestBody ProdutoVO produto) {
        return productService.update(produto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
