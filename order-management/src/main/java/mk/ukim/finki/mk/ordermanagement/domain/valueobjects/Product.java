package mk.ukim.finki.mk.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;


@Getter
public class Product implements ValueObject {
    private final ProductId id;
    private final String name;
    private final ProductCategory productCategory;
    private final Dimensions dimensions;
    private final Quantity quantity;
    private final Money price;
    private final String description;

    private Product() {
        this.id = ProductId.randomId(ProductId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, 0);
        this.productCategory = ProductCategory.Bedroom;
        this.dimensions = new Dimensions(0, 0, 0);
        this.quantity = new Quantity(0);
        this.description = "";
    }

    @JsonCreator
    public Product(@JsonProperty("id") ProductId id,
                   @JsonProperty("productName") String name,
                   @JsonProperty("productCategory") ProductCategory productCategory,
                   @JsonProperty("productDimensions") Dimensions dimensions,
                   @JsonProperty("quantity") Quantity quantity,
                   @JsonProperty("price") Money price,
                   @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
        this.dimensions = dimensions;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }
}