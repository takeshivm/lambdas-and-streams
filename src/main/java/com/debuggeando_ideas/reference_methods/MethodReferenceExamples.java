package com.debuggeando_ideas.reference_methods;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class MethodReferenceExamples {

    public static void main(String[] args) {

        // Video 2
        // Object method reference
        List<Integer> numbers = new ArrayList<>(10);
        IntStream repeat = IntStream.range(1,11);
        repeat.forEach(numbers::add);
        System.out.println(numbers);

        // Video 3
        // Referencia a metodos estaticos - Static Method Reference
            //Supplier<UUID> getToken = () -> UUID.randomUUID();
        Supplier<UUID> getToken = UUID::randomUUID;
        System.out.println(getToken.get());

        // Video 4
        // Referencia a metodos por constructor - Constructor Method Reference
            //Supplier<MyObject> myObjectSupplier = () -> new MyObject();
        Supplier<MyObject> myObjectSupplier = MyObject::new;
        System.out.println(myObjectSupplier.get());

        // Video 5
        // Referencia por metodo arbitrario - Arbitrary Method Reference
        //BiPredicate<String, String> equals = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> equals = String::equals;
        boolean isEquals = equals.test("a", "a");
        System.out.println(isEquals);
    }

}
