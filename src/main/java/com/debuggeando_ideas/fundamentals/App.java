package com.debuggeando_ideas.fundamentals;

import com.debuggeando_ideas.lambdas.Math;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ProductDB productDB = new ProductDB();
        EmployeeDB employeeDB = new EmployeeDB();

        System.out.println(productDB.getById(2L));
        System.out.println(employeeDB.getById(1L));

        System.out.println(Product.class.getName());
        System.out.println(Employee.class.getName());
        System.out.println(String.class.getName());


        // VIDEO    ->    3
        //En en caso de las clases anonimas, tenenemos nuestra interface DBSerice
        // Es clase anonima porque estoy implementando una interface dentro de una clase
        // Esta clase no implementa la interface, solo estoy creando una instancia de dicha interface
        DatabaseService<String> dbServiceAnonimo = new DatabaseService<String>() {
            @Override
            public String getById(Long id) {
                return "";
            }

            @Override
            public List<String> getAllRecords() {
                return List.of();
            }
        };

        System.out.println(dbServiceAnonimo.getClass().getName());
        /*
            El mensaje resultante, nos debería dar el nombre de la clase
            pero saldrá esto "com.debuggeando_ideas.fundamentals.App$1",
            debido a que el compilador esta creando una clase anoninma, que le asigna ese nombre
         * */

        // Clase anonima
        Math substract = new Math() {
            @Override
            public Double excecute(Double a, Double b) {
                return a - b;
            }
        };

        // Clase anonima
        Math muliply = (a, b) -> a*b;

        // Clase anonima
        Math divide = (a, b) -> a/b;

        System.out.println(substract.excecute(5.0, 2.0));
        System.out.println(muliply.excecute(5.0, 2.0));
        System.out.println(divide.excecute(5.0, 2.0));


    }

}
