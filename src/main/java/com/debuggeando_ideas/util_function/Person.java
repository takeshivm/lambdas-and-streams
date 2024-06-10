package com.debuggeando_ideas.util_function;

import lombok.ToString;

import java.io.Serializable;

@ToString
class Person implements Serializable {
    // Al decirle que es serializable, lo que hace es convertir en "0's y 1'"
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
