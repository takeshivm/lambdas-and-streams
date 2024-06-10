package com.debuggeando_ideas.util_function;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

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

    /*    Serializa un objeto    */
    static Function<Person, ByteArrayOutputStream> serializer = p -> {
        // Crea un ByteArrayOutputStream para almacenar los datos en memoria
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();

        // Usando try-with-resources para asegurar que el ObjectOutputStream se cierre automáticamente
        try (ObjectOutputStream outputStream = new ObjectOutputStream(inMemoryBytes)) {
            // Escribe el objeto Person en el ObjectOutputStream
            outputStream.writeObject(p);
            // Asegura que todos los datos se escriban en el ByteArrayOutputStream
            outputStream.flush();
        } catch (IOException ioe) {
            // Maneja cualquier IOException que ocurra
            System.err.println(ioe.getMessage());
        }

        // Devuelve el ByteArrayOutputStream que contiene los datos serializados
        return inMemoryBytes;
    };

    /*    Deserializa y devuelve una persona    */
    static Function<ByteArrayInputStream, Person> deserializer = bais -> {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(bais)){
            return (Person) objectInputStream.readObject();
        } catch(IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    };

    /*      BIFUNCTION      */
    /*  Se suele mas en acumuladores
        Ejmp: Si tenemos un lista de enteros, y queremos sumar todos los elementos
        de la lista para entregar un solo resultado
    * */
    private static <T, U, R> List<R> listCombiner(
            List<T> list1,
            List<U> list2,
            BiFunction<T, U, R> combiner
    ) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }

    /*      PREDICATE:      REMOVER ELEMENTOS BASADOS EN UN PREDICADO
     */
    static Predicate<Integer> isGreaterThan100 = n -> n >100;
    static Predicate<Integer> isLessThan10 = n -> n < 10;
    static Predicate<Integer> isBetween10And100 = isGreaterThan100.and(isLessThan10);
    static Predicate<Integer> isBetween10And1002 = isGreaterThan100.or(isLessThan10);


    public static void main(String[] args) {
        System.out.println(addThenMultiply.apply(5));
        System.out.println(composeMultiply.apply(5));

        /*    Ejemplos de la Interface Funtion 2    */
        // Ejemplo de uso del serializer
        ByteArrayOutputStream objectSerialized = serializer.apply(new Person("Takeshi", 30));
        System.out.println(Arrays.toString(objectSerialized.toByteArray()));

        Person objectDeserialized = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));
        System.out.println(objectDeserialized);


        // Ejemplo de uso de BIFUNCTION
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        // Usando una función combinadora que concatena el String y el Integer
        List<String> result = listCombiner(list1, list2, (l1, l2) -> l1 + l2);

        System.out.println(result);

        // Ejemplo de PREDICATE
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,10,20,50,100,150,200));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1,2,3,10,20,50,100,150,200));

        /*
        *   "isBetween10And100" nunca es verdadero, porque no existe un número que sea simultáneamente mayor que 100 y menor que 10.
            El negate() convierte isBetween10And100 a su negación.
            La negación de un predicado que nunca es verdadero es un predicado que siempre es verdadero.
            Por lo tanto, isBetween10And100.negate() siempre es verdadero, y removeIf eliminará todos los elementos de numbers.
            Resultado: [].
        * */
        numbers.removeIf(isBetween10And100.negate());
        System.out.println(numbers);

        /*  "isBetween10And1002" es verdadero si un número es mayor que 100 o menor que 10.   */
        numbers2.removeIf(isBetween10And1002);
        System.out.println(numbers2);

    }
}
