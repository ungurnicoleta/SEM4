import Service.BookServiceClient;
import Service.ClientServiceClient;
import UI.Console;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ClientApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "Config"
                );

        BookServiceClient bookServiceClient = context
                .getBean(BookServiceClient.class);

        ClientServiceClient clientServiceClient = context
                .getBean(ClientServiceClient.class);

        Console console = new Console(bookServiceClient, clientServiceClient);
        console.loop();
    }
}
