package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamUseCases {

    public static void main(String[] args) {

        Stream<Videogame> stream = Database.videogames.stream();

        minOperator(stream);

        /*
        reduceOperator(stream);

        findFirstOperatorSecond(stream);

        findAnyOperator(stream);

        findFirstOperator(stream);

        noneMatchOperator(stream);

        countOperator(stream);

        //Creamos otra vez el stream, porque el anterior se cerró
        Stream<Videogame> stream2 = Database.videogames.stream();
        forEachOperator(stream2);
        */

    }


    static void countOperator(Stream<Videogame> stream){
        System.out.println(stream.count());
    }

    static void forEachOperator(Stream<Videogame> stream) {
        stream.forEach(System.out::println);
    }

    static void anyMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.anyMatch(v -> v.getTotalSold() > 1);
        System.out.println(r);
    }

    static void allMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.allMatch(v -> v.getTotalSold() > 150);
        System.out.println(r);
    }

    // Basta con que solo un elemento no cumpla
    static void noneMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.noneMatch(v -> v.getReviews().isEmpty());
        System.out.println(r);
    }

    // Busca el primer elemento
    static void findFirstOperator(Stream<Videogame> stream) {

        /*
        * En Java, la clase Optional es una característica introducida en Java 8
        * que proporciona una forma de manejar valores que pueden estar presentes o
        * ausentes, evitando así el uso excesivo de null y reduciendo la posibilidad
        *  de errores de referencia nula (NullPointerException).
        * */
        Optional<Videogame> r = stream.findFirst();
        System.out.println(r);
    }

    // Busca el cualquier elemento
    static void findAnyOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.findAny();
        System.out.println(r);
    }

    /*
    * Métodos de Optional:

    isPresent(): Devuelve true si hay un valor presente, de lo contrario false.
    ifPresent(Consumer<? super T> action): Ejecuta la acción dada si hay un valor presente.
    orElse(T other): Devuelve el valor si está presente, de lo contrario devuelve other.
    orElseGet(Supplier<? extends T> other): Devuelve el valor si está presente,
    * de lo contrario devuelve el resultado del Supplier.
    orElseThrow(Supplier<? extends X> exceptionSupplier): Devuelve el valor
    * si está presente, de lo contrario lanza una excepción generada por el Supplier.
    * */

    static void findFirstOperatorSecond(Stream<Videogame> stream) {
        Optional<Videogame> optionalGame = stream.findFirst();

        optionalGame.ifPresent(videogame -> System.out.println("First game: " + videogame.getName()));
    }

    static void reduceOperator(Stream<Videogame> stream) {
        // Primero esamos haciendo un filtrado por descuento
        // Referencia arbitrtaria por el elementro getTotalSold, para filtrar solo los que  me intersan
        // Reduce: Haciendo la suma del total de vendidos

        Optional<Integer> r = stream
                .filter(Videogame::getIsDiscount)
//                .filter(videogame -> !videogame.getIsDiscount())
                        .map(Videogame::getTotalSold)
                                .reduce((a,b) -> a + b);
//                                .reduce(Integer::sum);

        System.out.println(r);
    }

    static void maxOperator(Stream<Videogame> stream) {
        //Optional<Videogame> r = stream.max((a,b) -> a.getName().compareTo(b.getName()));
        Optional<Videogame> r = stream.max(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }

    static void minOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.min(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }


}
