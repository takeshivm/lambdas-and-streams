package com.debuggeando_ideas.lambdas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class LambdasScope {

    public static void main(String[] args) {

        // Variable volatil, significa que puede estar en varios hilos
        // Va a ser una variable concurrente
        AtomicInteger num = new AtomicInteger(10);
        //AtomicReference<Product>


        // Cuando declaraba num como integer, la exp. lambda no reconocia porque
        // estaba fuera del scope
        //IntStream.range(1,10).forEach(i -> num = num + i);
        IntStream.range(1,10).forEach(i -> num.set(num.get() + i));
        //No podemos alterar una variable que este fuera de la exp. Lambda


    }
}
