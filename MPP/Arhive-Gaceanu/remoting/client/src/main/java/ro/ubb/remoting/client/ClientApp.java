package ro.ubb.remoting.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.remoting.client.service.StudentServiceClient;

/**
 * author: radu
 */
public class ClientApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.remoting.client.config"
                );

        StudentServiceClient studentServiceClient = context
                .getBean(StudentServiceClient.class);
        studentServiceClient.findAll()
                            .forEach(student -> System.out.println(student));

        System.out.println("bye client");
    }
}
