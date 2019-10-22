package ro.ubb.remoting.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: radu
 */
public class ServerApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.remoting.server.config"
                );

        System.out.println("server starting...");
    }
}
