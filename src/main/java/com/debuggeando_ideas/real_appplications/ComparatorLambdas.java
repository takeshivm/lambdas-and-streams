package com.debuggeando_ideas.real_appplications;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdas {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3,8,1,7,10,9,4,2,6,5);
        numbers.sort((o1, o2) -> o1-o2);
        System.out.println(numbers);
        List<String> names = Arrays.asList("Takeshi","Andrea","Maximo");
        names.sort(String::compareTo);
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);

        List<Person> persons = Arrays.asList(
                new Person("Xiomara",27),
                new Person("Edu",30),
                new Person("Cristina",19),
                new Person("Diana",19),
                new Person("Valentina",23)
        );

        persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println(persons);
    }
}

@Data // Setters y Getters
@AllArgsConstructor // Todos los argurmentos del constructor
class Person {
    private String name;
    private Integer age;
}
