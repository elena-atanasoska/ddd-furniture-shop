package mk.ukim.finki.mk.ordermanagement.service;


import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.mk.ordermanagement.domain.model.Order;
import mk.ukim.finki.mk.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.mk.ordermanagement.domain.valueobjects.*;
import mk.ukim.finki.mk.ordermanagement.service.forms.OrderForm;
import mk.ukim.finki.mk.ordermanagement.service.forms.OrderItemForm;
import mk.ukim.finki.mk.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.mk.ordermanagement.xport.client.ProductClient;
import org.glassfish.jaxb.runtime.v2.runtime.output.SAXOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;


    private static Product newProduct(String name, ProductCategory productCategory, Dimensions dimensions, Quantity quantity, Money price, String desc) {
        Product p = new Product(ProductId.randomId(ProductId.class), name, productCategory, dimensions, quantity, price, desc);
        return p;
    }

    @Test
    public void testPlaceOrder() {

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setProduct(newProduct("Trosed", ProductCategory.LivingRoom, new Dimensions(12,2,6), new Quantity(12), Money.valueOf(Currency.MKD,1000), "opis2"));
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setProduct(newProduct("Krevet", ProductCategory.Bedroom, new Dimensions(22,12,26), new Quantity(6), Money.valueOf(Currency.MKD,1200), "opis5"));
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setItems(Arrays.asList(oi1,oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);
        Assertions.assertEquals(newOrder.total(),Money.valueOf(Currency.MKD,2500));

    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<Product> productList = productClient.findAll();
        System.out.println(productList);
        Product p1 = productList.get(0);
        Product p2 = productList.get(1);

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setProduct(p1);
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setProduct(p2);
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setItems(Arrays.asList(oi1,oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);

        Money outMoney = p1.getPrice().multiply(oi1.getQuantity()).add(p2.getPrice().multiply(oi2.getQuantity()));
        Assertions.assertEquals(newOrder.total(),outMoney);
    }
}