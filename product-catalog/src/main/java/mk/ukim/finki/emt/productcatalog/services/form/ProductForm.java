package mk.ukim.finki.emt.productcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.productcatalog.domain.enums.ProductCategory;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Dimensions;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class ProductForm {
    private String productName;
    private ProductCategory productCategory;
    private Dimensions productDimensions;
    private Quantity quantity;
    private Money price;
    private String description;
}
