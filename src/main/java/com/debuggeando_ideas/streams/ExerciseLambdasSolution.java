package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Console;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class ExerciseLambdasSolution {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        exercise5(videogames).forEach(System.out::println);
        //exercise4(videogames).forEach(System.out::println);
        //  System.out.println(exercise3(videogames));
        //  exercise2(videogames).forEach(System.out::println);
        //  System.out.println(exercise1(videogames));

        //exercise5(videogames).forEach(System.out::println);
    }

    /*
     *Regresar true si el stream contiene al menos un videojuego con número de ventas mayor a 10
     * y no este en descuento o su precio sea mayor a 9.99 de lo contrario regresar false.
     */
    static Boolean exercise1(Stream<Videogame> stream) {
        return stream.anyMatch(v -> v.getTotalSold() > 10 && (!v.getIsDiscount() || v.getPrice() > 9.99));
    }

    /*
     *Regresar un Stream unicamente con los titulos de todas las consolas que sean de XBOX
     * durante el proceso imprimir los resultados ignorando los repetidos.
     */
    static Stream<String> exercise2(Stream<Videogame> stream) {
        return stream
                .distinct()
                .filter(v -> v.getConsole().equals(Console.XBOX))
                .peek(v -> System.out.println("Process: " + v))
                .map(Videogame::getName);
    }

    /*
     *Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los primers 10 elementos del stream.
     */
    static Videogame exercise3(Stream<Videogame> stream) {
        return stream
                .limit(10)
                .max(Comparator.comparing(Videogame::getTotalSold))
                .orElseThrow(NoSuchElementException::new);
    }

    /*
     *Regresar un stream con todos los comentarios del cada review de todos los videojuegos del stream.
     */
    static Stream<String> exercise4(Stream<Videogame> stream) {
        return stream
                .flatMap(v -> v.getReviews().stream().map(Review::getComment));
    }

    /*
     *Regresar un stream con los todos los videojuegos con precio menores a 20.0
     * sin utilizar el operador filter().
     */
    static Stream<Double> exercise5(Stream<Videogame> stream) {
        return stream
                .sorted(Comparator.comparing(Videogame::getPrice))
                .takeWhile(v -> v.getPrice() < 20.0)
                .map(Videogame::getPrice);
    }

}
