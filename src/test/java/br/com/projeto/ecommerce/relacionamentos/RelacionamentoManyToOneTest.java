package br.com.projeto.ecommerce.relacionamentos;

import br.com.projeto.ecommerce.EntityManagerTest;
import br.com.projeto.ecommerce.entity.ClienteEntity;
import br.com.projeto.ecommerce.entity.PedidoEntity;
import br.com.projeto.ecommerce.entity.StatusPedidoEnum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        ClienteEntity cliente = entityManager.find(ClienteEntity.class, 1);

        PedidoEntity pedido = new PedidoEntity();
        pedido.setStatus(StatusPedidoEnum.PAGO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        PedidoEntity pedidoVerificacao = entityManager.find(PedidoEntity.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getCliente());
    }
}
