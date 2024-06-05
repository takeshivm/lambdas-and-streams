package com.debuggeando_ideas.lambdas;

// FunctionalInterface DEBE TENER AL MENOS UN METODO ABSTRACTO
// Ademas tener en cuenta la FunctinoaInterface solo debe tener un metodo abstracto
@FunctionalInterface
public interface Printer<T> {

    void print(T toPrint);
}
