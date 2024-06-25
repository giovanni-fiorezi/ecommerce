package br.com.projeto.ecommerce.service;

import br.com.projeto.ecommerce.entity.ProdutoEntity;
import br.com.projeto.ecommerce.enums.CategoriaEnum;
import br.com.projeto.ecommerce.exceptions.RequiredObjectIsNullException;
import br.com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import br.com.projeto.ecommerce.mapper.ModelMapper;
import br.com.projeto.ecommerce.repository.ProdutoRepository;
import br.com.projeto.ecommerce.resource.ProdutoResource;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private Logger logger = Logger.getLogger(ProdutoService.class.getName());

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoVO> findAll() {
        logger.info("Bucando todos os produtos.");

        List<ProdutoVO> produtosVosList = ModelMapper.parseListObjects(repository.findAll(), ProdutoVO.class);
        produtosVosList
                .stream()
                .forEach(produtoVO -> produtoVO.add(linkTo(methodOn(ProdutoResource.class).findById(produtoVO.getKey())).withSelfRel()));

        return produtosVosList;
    }

    /* Método para buscar uma lista de produtos com base na categoria, passada via parametro */
    public List<ProdutoVO> findByCategoria(CategoriaEnum categoria) {
        logger.info("Buscando todos os: " + categoria.getDescricao());

        List<ProdutoEntity> produtosList = repository.findAll().stream()
                .filter(categoriaProduto -> categoriaProduto.getCategoria().equals(categoria))
                .collect(Collectors.toList());

        return ModelMapper.parseListObjects(produtosList, ProdutoVO.class);
    }

    public ProdutoVO findById(Long id) {
        logger.info("Buscando um produto.");
        ProdutoEntity produtoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com esse id: " + id));
        ProdutoVO vo = ModelMapper.parseObject(produtoEntity, ProdutoVO.class);
        vo.add(linkTo(methodOn(ProdutoResource.class).findById(id)).withSelfRel());
        return vo;
    }

    public ProdutoVO create(ProdutoVO produto) {

        if(produto == null) throw new RequiredObjectIsNullException();

        logger.info("Inserindo um produto");

        ProdutoEntity produtoEntity = ModelMapper.parseObject(produto, ProdutoEntity.class);
        ProdutoEntity produtoSave = repository.save(produtoEntity);
        ProdutoVO vo = ModelMapper.parseObject(produtoSave, ProdutoVO.class);
        vo.add(linkTo(methodOn(ProdutoResource.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public ProdutoVO update(ProdutoVO produto) {

        if(produto == null) throw new RequiredObjectIsNullException();

        logger.info("Atualizando um produto.");

        //Aqui eu pego o id do produto que estou passando
        Long produtoId = produto.getKey();

        //Verifica se o id que eu passei consta no banco
        ProdutoEntity produtoEntity = repository.findById(produtoId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Id %d não existe", produtoId)));

        //Salvando a entidade no banco
        ProdutoEntity produtoSave = repository.save(produtoEntity);
        ProdutoVO vo = ModelMapper.parseObject(produtoSave, ProdutoVO.class);
        vo.add(linkTo(methodOn(ProdutoResource.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deletando um produto.");

        //Verifico se existe esse id passado no Banco, caso não exista lança a exceção
        ProdutoEntity produtoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Id %d não existe", id)));

        repository.delete(produtoEntity);
    }

    public List<ProdutoVO> lerPlanilhaXlsx(MultipartFile file) throws IOException {
        List<ProdutoVO> produtos = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            List<Row> rows = (List<Row>) toList(sheet.iterator());

            rows.remove(0);

            rows.forEach(row -> {
                List<Cell> cells = (List<Cell>) toList(row.cellIterator());

                ProdutoVO vo = ProdutoVO.builder()
                        .name(cells.get(0).getStringCellValue() != null ? cells.get(0).getStringCellValue() : "")
                        .descricao(cells.get(1).getStringCellValue() != null ? cells.get(1).getStringCellValue() : "")
                        .preco(cells.get(2).getCellType() == null ? BigDecimal.valueOf(cells.get(2).getNumericCellValue()) : BigDecimal.ZERO)
                        .categoria(CategoriaEnum.valueOf(cells.get(3).getStringCellValue() != null ? cells.get(3).getStringCellValue() : ""))
                        .build();

                produtos.add(vo);
            });

            for (ProdutoVO produto : produtos) {
                ProdutoEntity produtoEntity = ModelMapper.parseObject(produto, ProdutoEntity.class);
                repository.save(produtoEntity);
            }
        }
        return produtos;
    }

    private List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }

}
