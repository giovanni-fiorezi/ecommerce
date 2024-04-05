package br.com.projeto.ecommerce.util;

import br.com.projeto.ecommerce.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IniciarUnidadeDePersistencia {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ProductEntity produto = entityManager.find(ProductEntity.class, 1);
        System.out.println(produto.getName());

        entityManager.close();
        entityManagerFactory.close();
    }
}
