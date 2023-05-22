package mk.ukim.finki.mk.ordermanagement.service;

import mk.ukim.finki.mk.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.mk.ordermanagement.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.mk.ordermanagement.domain.model.Order;
import mk.ukim.finki.mk.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.mk.ordermanagement.domain.model.OrderItemId;
import mk.ukim.finki.mk.ordermanagement.service.forms.OrderForm;
import mk.ukim.finki.mk.ordermanagement.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException;

}
