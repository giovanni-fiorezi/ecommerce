package br.com.projeto.ecommerce.webservices;

import br.com.projeto.ecommerce.entity.EnderecoEntregaPedido;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCepRestTemplateService {

    public EnderecoEntregaPedido consultaCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EnderecoEntregaPedido> responseEndereco = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep),
                EnderecoEntregaPedido.class);

        return responseEndereco.getBody();
    }
}
