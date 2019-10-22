package ro.ubb.springdi.springdi1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.springdi.springdi1.ui.Console;

/**
 * author: radu
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.springdi.springdi1");

        Console console = context.getBean(Console.class);
        console.run();

        System.out.println("bye");
    }
}
