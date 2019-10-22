package ro.ubb.catalog.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.dto.BookDto;
import ro.ubb.catalog.web.dto.BooksDto;

public class ClientApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.catalog.client.config"
                );

        RestTemplate restTemplate = context.getBean(RestTemplate.class);


        BookDto newBook = BookDto.builder()
                .author("sNEW")
                .title("ceva")
                .ISBN("1234567890987")
                .price(10.00f)
                .quantity(100)
                .build();
        BookDto savedBook = restTemplate.postForObject(
                "http://localhost:8080/api/books",
                newBook,
                BookDto.class
        );

        savedBook.setQuantity(10);
        restTemplate.put(
                "http://localhost:8080/api/books/{id}",
                savedBook,
                savedBook.getId()
        );

        restTemplate.delete(
                "http://localhost:8080/api/books/{id}",
                savedBook.getId()
        );

        BooksDto booksDto = restTemplate.getForObject(
                "http://localhost:8080/api/books",
                BooksDto.class
        );
        System.out.println(booksDto);

        System.out.println("bye ");
    }
}
