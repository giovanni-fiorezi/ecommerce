package br.com.projeto.ecommerce.webservices;

import br.com.projeto.ecommerce.entity.EnderecoEntregaPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta-cep")
public class ConsultaCepRestTemplateController {

    @Autowired
    private ConsultaCepRestTemplateService service;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoEntregaPedido> consultaCep(@PathVariable("cep") String cep) {
        EnderecoEntregaPedido endereco = service.consultaCep(cep);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }
}
