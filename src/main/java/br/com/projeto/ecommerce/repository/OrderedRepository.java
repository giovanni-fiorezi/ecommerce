package br.com.projeto.ecommerce.repository;

import br.com.projeto.ecommerce.entity.OrderedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderedRepository extends JpaRepository<OrderedEntity, Integer> {
	
    Optional<OrderedEntity> findByOrderedNumber(Integer orderedNumber);
}
