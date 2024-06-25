package br.com.projeto.ecommerce.resource;

import br.com.projeto.ecommerce.enums.CategoriaEnum;
import br.com.projeto.ecommerce.service.ProdutoService;
import br.com.projeto.ecommerce.util.MediaType;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
@Tag(name = "Produtos", description = "Endpoints para gerenciamento de Produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService productService;

    @GetMapping(produces = {
            MediaType.MEDIA_TYPE_APPLICATION_JSON,
            MediaType.MEDIA_TYPE_APPLICATION_YML,
            MediaType.MEDIA_TYPE_APPLICATION_XML })
    @Operation(summary = "Buscando todos os produtos", description = "Buscando todos os produtos",
        tags = {"Produtos"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProdutoVO.class))
                            )
            }),
                @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
        })
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

//    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}",
            produces = { MediaType.MEDIA_TYPE_APPLICATION_JSON, MediaType.MEDIA_TYPE_APPLICATION_YML, MediaType.MEDIA_TYPE_APPLICATION_XML })
    @Operation(summary = "Buscando Produto", description = "Buscando Produto",
            tags = {"Produtos"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ProdutoVO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ProdutoVO findById(@PathVariable(value="id") Long id) {
        return productService.findById(id);
    }

//    @CrossOrigin(origins = {"http://localhost:8080", "https://ecommerce.com.br"})
    @PostMapping(produces = {
            MediaType.MEDIA_TYPE_APPLICATION_JSON,
            MediaType.MEDIA_TYPE_APPLICATION_YML,
            MediaType.MEDIA_TYPE_APPLICATION_XML },
            consumes = { MediaType.MEDIA_TYPE_APPLICATION_JSON, MediaType.MEDIA_TYPE_APPLICATION_YML, MediaType.MEDIA_TYPE_APPLICATION_XML })
    public ProdutoVO create(@RequestBody ProdutoVO produto) {
        return productService.create(produto);
    }

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

    @PostMapping("/post-products-file")
    public ResponseEntity<List<ProdutoVO>> lerPlanilhaXlsx(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        List<ProdutoVO> produtos = productService.lerPlanilhaXlsx(multipartFile);
        return ResponseEntity.ok(produtos);
    }

}
