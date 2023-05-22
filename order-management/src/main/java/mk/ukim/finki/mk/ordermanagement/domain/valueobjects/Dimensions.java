package mk.ukim.finki.mk.ordermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Dimensions implements ValueObject {
    private final int width;
    private final int height;
    private final int depth;

    public Dimensions() {
        this.width = 0;
        this.height = 0;
        this.depth = 0;
    }

    public Dimensions(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
