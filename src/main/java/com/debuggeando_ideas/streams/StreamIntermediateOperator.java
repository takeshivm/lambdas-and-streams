package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperator {


    public static void main(String[] args) {
        Stream<Videogame> stream = Database.videogames.stream();

        filterOperator(stream);
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




}