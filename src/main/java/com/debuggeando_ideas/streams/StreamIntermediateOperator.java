package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperator {


    public static void main(String[] args) {
        Stream<Videogame> stream = Database.videogames.stream();

        mapOperator(stream);
        //filterOperator(stream);
        //limitOperator(stream);
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
        titles.forEach(System.out::println);
    }


}