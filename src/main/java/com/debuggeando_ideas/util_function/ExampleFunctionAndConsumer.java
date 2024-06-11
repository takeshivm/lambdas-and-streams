package com.debuggeando_ideas.util_function;

import java.util.*;
import java.util.function.*;

public class ExampleFunctionAndConsumer {

    // Function BIPREDICATE
    static BiPredicate<String, String> myEquals = (s1, s2) -> s1.concat(s2).equals("Takeshi Vargas");

    // INTERFACE SUPPLIER
    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static Supplier<MyProduct> productSupplier = () -> new MyProduct(1000, "Desktop PC");

    // INTERFACE UNARY OPERATOR
        //      static Function<String, String> funToUpper1 = s -> s.toUpperCase();
        ///     CON REFERENCIA DE METODOS
    static Function<String, String> funToUpper = String::toUpperCase;
    static UnaryOperator<String> unaryToUpper = String::toUpperCase;

    // INTERFACE UNARY OPERATOR, recibe el mismo argumento de entrada y de salida
    // INTERFACE UNARY OPERATOR, EXTIENDE DE LA INTERFAZ FUNCTION

    static UnaryOperator<Integer> int1 = n -> n * n;
    static IntUnaryOperator int2 = n -> n * n;






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

        // INTERFACE UNARYOPERATOR
        String arg = "lambdas";

        System.out.println(funToUpper.apply(arg));
        System.out.println(unaryToUpper.apply(arg));

        System.out.println(int1.apply(3));
        System.out.println(int2.applyAsInt(2));

        // INTERFACE BIUNARYOPERATOR, EXTIENDE DE LA INTERFAZ BIFUNCTION
        // por lo tanto, vamos a recibir 2 argumentos
        BiFunction<String, String, String> normalizerFunc = (a,b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizerFunc.apply("hola ","MUNDO"));

        BinaryOperator<String> normalizer = (a,b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizer.apply("hola ","MUNDO"));




    }
}
