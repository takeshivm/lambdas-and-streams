package com.debuggeando_ideas.util_function;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class ExampleFunctionAndConsumer {

    // Function BIPREDICATE
    static BiPredicate<String, String> myEquals = (s1, s2) -> s1.concat(s2).equals("Takeshi Vargas");

    // INTERFACE SUPPLIER
    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static Supplier<MyProduct> productSupplier = () -> new MyProduct(1000, "Desktop PC");



    public static void main(String[] args) {
        String s1 = "Takeshi ";
        String s2 = "Vargas";

        System.out.println(myEquals.test(s1,s2));

        // INTERFACE CONSUMER
        Set<Integer> nums = Set.of(1,2,3,4,5,6);
        List<Integer> squares = new LinkedList<>();

        nums.forEach(n -> squares.add(n * n));
        System.out.println(squares);


        // INTERFACE BICONSUMER
        Map<Boolean, String> maps = Map.of(true, "this is the True", false, "This is false");

        maps.forEach((k, v) -> System.out.println(k + " - " + v));

        // INTERFACE SUPPLIER
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(productSupplier.get());


    }
}
