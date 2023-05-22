package mk.ukim.finki.emt.productcatalog.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;


@Embeddable
@Getter

public class Quantity implements ValueObject {
    private final int quantity;

    public Quantity() {
        this.quantity = 0;
    }


    public Quantity add(int other) {
        int newQuantity = this.quantity + other;
        return new Quantity(newQuantity);
    }

    public Quantity subtract(int other) {
        int newQuantity = this.quantity - other;
        return new Quantity(newQuantity);
    }

    public Quantity(int quantity) {
        this.quantity = quantity;
    }
}
