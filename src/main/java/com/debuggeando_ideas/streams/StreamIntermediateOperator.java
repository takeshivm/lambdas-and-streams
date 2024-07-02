package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperator {


    public static void main(String[] args) {
        Stream<Videogame> stream = Database.videogames.stream();

        dropWhileOperator(stream);
        // takeWhileOperator(stream);
        // sortOperator(stream);
        // peekOperator(stream);
        // flatMapOperator(stream);
        // mapOperator(stream);
        // filterOperator(stream);
        // limitOperator(stream);
        //  distinctOperator(stream);


    }

    static void distinctOperator(Stream<Videogame> stream) {
        System.out.println(stream.distinct().count());
    }

    static void limitOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.limit(5).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void skipOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.limit(5).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    // Unos de los operadores más usados
    static void filterOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .filter(v -> v.getPrice() > 12.0)
                .filter(v -> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());

        r.forEach(System.out::println);
    }

    // El operador más usado "MAP"
    // Map, se usa para transformar datos, hacer una operación
    // y traer datos nuevos a partir de los datos originales
    static void mapOperator(Stream<Videogame> stream) {
        List<BasicVideogame> basicVideogames = stream
                .map(v -> {
                   //Por cada elemento me retorne
                   return BasicVideogame.builder()
                           .name(v.getName())
                           .price(v.getPrice())
                           .console(v.getConsole())
                           .build();
                }).collect(Collectors.toList());

        List<String> titles = basicVideogames.stream()
                .map(BasicVideogame::getName)
                .collect(Collectors.toList());

        basicVideogames.forEach(System.out::println);
        System.out.println("--------------");
        titles.forEach(System.out::println);
    }

    // Unos de los operadores más usados
    static void flatMapOperator(Stream<Videogame> stream) {
        // Primer ejemplo
        List<Review> r = stream.flatMap( v -> v.getReviews().stream()).collect(Collectors.toList());

        System.out.println(r);
    }

    static void mapVSFlatMapOperator(Stream<Videogame> stream) {
        //  Map
        //var totalReviews = stream.map( v -> v.getReviews().size()).collect(Collectors.toList());
        Long totalReviews = stream.map( v -> v.getReviews().stream()).count();

        System.out.println(totalReviews);
    }

    // PEEK es un operador intermedio, por ende me regresa otro stream
    // For each no eun un op. intermedio, por lo tanto al hacer "sout" si imprime los datos
    static void peekOperator(Stream<Videogame> stream) {
        //  El metodo PEEK sirve para hacer una operacion sobre el stream
        //  y me devuelve otro stream, y no se ejecuta, a menos que mademos
        // a llamar a otro operador final

        stream.peek(v -> v.setName("")).forEach(System.out::println);
        //Otro ejemplo
        //stream.peek(System.out::println).forEach(System.out::println);
    }

    // SORT OPERATOR
    static void sortOperator(Stream<Videogame> stream) {
        //  Ordenar por el numero de reviews, la que tenga menos reviews saldra al principio
        List<Videogame> listSorted = stream
                .sorted(Comparator.comparingInt(v -> v.getReviews().size()))
                .collect(Collectors.toList());

        listSorted.forEach(System.out::println);
    }

    // TAKE WHILE
    static void takeWhileOperator(Stream<Videogame> stream) {
        //  Primero debe estar ordenada bajo nuestro criterio
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName)) // Trae primero desde la a - z
                .takeWhile(v -> !v.getName().startsWith("M")) // Toma todos los valores antes que se cumpla la condicion
                .collect(Collectors.toList());

        r.forEach(System.out::println);
    }

    // DROP WHILE
    static void dropWhileOperator(Stream<Videogame> stream) {
        //  Primero debe estar ordenada bajo nuestro criterio
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName)) // Trae primero desde la a - z
                // Borra todos mientras no se cumpla la condicion
                .dropWhile(v -> !v.getName().startsWith("M")) // Regresa los ultimos elementos
                .collect(Collectors.toList());

        r.forEach(System.out::println);
    }



}