import Domain.Book;
import Service.BookServiceClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ClientApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "Config"
                );

        BookServiceClient bookServiceClient = context
                .getBean(BookServiceClient.class);

        Book book1 = new Book("Ana", "Licenta50", "1234567890980", 100, 10);
        book1.setId(50l);
        bookServiceClient.add(book1);

        bookServiceClient.findAll()
                .forEach(book -> System.out.println(book));

        System.out.println(String.format("Book with id 50 was added"));
        System.out.println("bye client");
    }
}
