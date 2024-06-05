package com.debuggeando_ideas.lambdas;

// FunctionalInterface DEBE TENER AL MENOS UN METODO ABSTRACTO
// Ademas tener en cuenta la FunctinoaInterface solo debe tener un metodo abstracto
@FunctionalInterface
public interface Math {

    // Por lo tanto implementamos el siguiente metodo
    Double excecute(Double a, Double b);

    // Podemos tener metodos por default, usa la palabra reservada (Default)
    default Double sum(Double a, Double b) { return  a + b; }
}
