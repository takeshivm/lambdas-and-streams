package com.debuggeando_ideas.lambdas;

import com.debuggeando_ideas.fundamentals.Employee;
import com.debuggeando_ideas.fundamentals.Product;

public class AppGenericLambda {

    public static void main(String[] args) {

        // La interfaz printer es generica y le podemos pasar cuaquier tipo de objeto
        Printer<String> printString = string -> System.out.println(string);
        Printer<Product> printProduct = product -> System.out.println(product);
        Printer<Employee> printEmployee = employee -> System.out.println(employee);

        Product product = new Product();
        product.setId(11234L);
        product.setName("Nokia");
        product.setPrice(12313.20);

        printProduct.print(product);
    }
}
