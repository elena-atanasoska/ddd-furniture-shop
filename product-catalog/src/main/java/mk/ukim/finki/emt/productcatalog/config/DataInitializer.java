package mk.ukim.finki.emt.productcatalog.config;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.enums.ProductCategory;
import mk.ukim.finki.emt.productcatalog.domain.models.Product;
import mk.ukim.finki.emt.productcatalog.domain.repository.ProductRepository;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Dimensions;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.productcatalog.xport.rest.ProductResource;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        Product p1 = Product.build("Stolce", ProductCategory.Bedroom, new Dimensions(2,3,4), new Quantity(2), Money.valueOf(Currency.MKD,100), "opis1" );
        Product p2 = Product.build("Masa", ProductCategory.Bedroom, new Dimensions(5,6,7), new Quantity(6), Money.valueOf(Currency.MKD,200), "opis2");
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(p1,p2));
        }
    }
}

