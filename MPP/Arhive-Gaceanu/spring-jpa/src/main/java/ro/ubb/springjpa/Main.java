package ro.ubb.springjpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.springjpa.ui.Console;

/**
 * author: radu
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(
                  "ro.ubb.springjpa.config"
                );

        Console console=context.getBean(Console.class);
        console.run();

        System.out.println("hello");
    }
}
