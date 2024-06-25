//package br.com.projeto.ecommerce.unittests.mockito.service;
//
//import br.com.projeto.ecommerce.entity.ProdutoEntity;
//import br.com.projeto.ecommerce.enums.CategoriaEnum;
//import br.com.projeto.ecommerce.repository.ProdutoRepository;
//import br.com.projeto.ecommerce.service.ProdutoService;
//import br.com.projeto.ecommerce.unittests.mockito.mapper.MockProduto;
//import br.com.projeto.ecommerce.vo.v1.ProdutoVO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(MockitoExtension.class)
//class ProdutoServiceTest {
//
//    MockProduto input;
//
//    @InjectMocks
//    private ProdutoService service;
//
//    @Mock
//    ProdutoRepository repository;
//
//    @BeforeEach
//    void setUpMocks() {
//        input = new MockProduto();
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void findByCategoria() {
//    }
//
//    @Test
//    void findById() {
//        ProdutoEntity produto = input.mockEntity();
//        produto.setId(1L);
//
//        when(repository.findById(1L)).thenReturn(Optional.of(produto));
//
//        ProdutoVO result = service.findById(1L);
//        assertNotNull(result);
//        assertNotNull(result.getKey());
//        assertNotNull(result.getLinks());
//        System.out.println(result.getLinks());
//        assertTrue(result.toString().contains("links: [</api/product/v1/1>;rel=\"self\"]"));
//
//        assertEquals("", result.getName());
//        assertEquals("", result.getDescricao());
//        assertEquals(CategoriaEnum.ELETRONICO, result.getCategoria());
//    }
//
//    @Test
//    void create() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
//}