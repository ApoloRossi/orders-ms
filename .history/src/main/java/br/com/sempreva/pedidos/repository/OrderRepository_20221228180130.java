package br.com.sempreva.pedidos.repository;

import br.com.sempreva.pedidos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
