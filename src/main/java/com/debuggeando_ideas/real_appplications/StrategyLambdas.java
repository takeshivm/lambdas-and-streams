package com.debuggeando_ideas.real_appplications;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

public class StrategyLambdas {

    public static void main(String[] args) {
        var product1 = Product.builder().id(1L).name("PC").price(2000.00).userType("BASIC").build();
        var product2 = Product.builder().id(1L).name("Laptop").price(2000.00).userType("PLUS").build();
        var product3 = Product.builder().id(1L).name("Tablet").price(2000.00).userType("PRIME").build();
        var products = List.of(product1, product2, product3);

        products.forEach(p -> {
            switch (p.getUserType()) {
                case "BASIC": p.setDiscountStrategy(Strategies.basicDiscount); break;
                case "PLUS": p.setDiscountStrategy(Strategies.plusDiscount); break;
                case "PRIME": p.setDiscountStrategy(Strategies.primeDiscount); break;
            }
        });

        products.forEach(p -> {
            System.out.println("Price: " + p.getPrice() + "User Type: " + p.getUserType() + "Discount: " + p.getDiscountStrategy().get(p.getPrice()));
        });
    }
}

@FunctionalInterface
interface ApplyDiscountStrategy {
    Double get (Double price);
}

class Strategies {
    static ApplyDiscountStrategy basicDiscount = p -> p * 0.02;
    static ApplyDiscountStrategy plusDiscount = p -> p * 0.05;
    static ApplyDiscountStrategy primeDiscount = p -> p * 0.08;
}


@Data
@ToString
@Builder
class Product {
    private Long id;
    private String userType;
    private String name;
    private Double price;
    private ApplyDiscountStrategy discountStrategy;
}
