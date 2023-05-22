package mk.ukim.finki.mk.ordermanagement.domain.repository;

import mk.ukim.finki.mk.ordermanagement.domain.model.Order;
import mk.ukim.finki.mk.ordermanagement.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
