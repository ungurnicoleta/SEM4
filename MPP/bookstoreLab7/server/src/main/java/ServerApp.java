import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "Config"
                );

        System.out.println("server starting...");
    }
}
