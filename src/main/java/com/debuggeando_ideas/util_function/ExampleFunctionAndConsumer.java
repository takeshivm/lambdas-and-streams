package com.debuggeando_ideas.util_function;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;

public class ExampleFunctionAndConsumer {

    // Function BIPREDICATE
    static BiPredicate<String, String> myEquals = (s1, s2) -> s1.concat(s2).equals("Takeshi Vargas");

    // INTERFACE CONSUMER


    public static void main(String[] args) {
        String s1 = "Takeshi "; S
        String s2 = "Vargas";

        System.out.println(myEquals.test(s1,s2));


        Set<Integer> nums = Set.of(1,2,3,4,5,6);
        List<Integer> squares = new LinkedList<>();

        nums.forEach(n -> squares.add(n * n));
        System.out.println(squares);

        Map<Boolean, String> maps = Map.of(true, "this is the True", false, "This is false");

        maps.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
