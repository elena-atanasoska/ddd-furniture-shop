package mk.ukim.finki.mk.ordermanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.mk.ordermanagement.domain.valueobjects.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private Product product;

    @Min(1)
    private int quantity = 1;
}
