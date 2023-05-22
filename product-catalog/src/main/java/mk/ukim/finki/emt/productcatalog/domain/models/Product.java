package mk.ukim.finki.emt.productcatalog.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.productcatalog.domain.enums.ProductCategory;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Dimensions;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "product")
@Getter
public class Product extends AbstractEntity<ProductId> {

    private String productName;
    @Enumerated(value = EnumType.STRING)
    private ProductCategory productCategory;
    private Dimensions productDimensions;
    private Quantity quantity;
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;
    private String description;

    public Product() {
        super(ProductId.randomId(ProductId.class));
    }

    public static Product build(String productName, ProductCategory productCategory, Dimensions productDimensions, Quantity quantity, Money price, String description) {
        Product p = new Product();
        p.productName = productName;
        p.productCategory = productCategory;
        p.productDimensions = productDimensions;
        p.quantity = quantity;
        p.price = price;
        p.description = description;
        return p;
    }

    public void addQuantity(int qty) {
        this.quantity = quantity.add(qty);
    }

    public void removeQuantity(int qty) {
        this.quantity = quantity.subtract(qty);
    }

}