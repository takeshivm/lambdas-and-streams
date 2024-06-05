package com.debuggeando_ideas.lambdas;

import java.util.List;

public class AppLambda {

    public static void main(String[] args) {

        // Sin Lambda
        List<String> countries = List.of("Perú","Colombia","Uruguay","Brazil");

        for (String c : countries) {
            System.out.println(c);
        }

        // Con Lambda
        countries.forEach(s -> System.out.println("Con Lambda: " + countries.indexOf(s) + " - " + s));
    }
}
