package com.debuggeando_ideas.util_function;

import java.util.function.Function;

// INTERFACE FUNCTION
public class ExampleFunction {

    static Function<Integer, Integer> multiply = n -> n * 10;
    static Function<Integer, Integer> sum = n -> n + 10;

    // Ejecuta primero la multiplicacion, luego la suma
    static Function<Integer, Integer> composeMultiply = multiply.compose(sum);
    // Ejecuta primero la suma (Lo que esta dentro), y luego la ,multiplicaciòn
    static Function<Integer, Integer> addThenMultiply = multiply.andThen(sum);

    /*    Implementando la Interface Funtion 2    */
    /* Usamos la interfaz functino para poder realizar cualquier
        operaciòn con un objeto
     */









    public static void main(String[] args) {
        System.out.println(addThenMultiply.apply(5));
        System.out.println(composeMultiply.apply(5));
    }
}
