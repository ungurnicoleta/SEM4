package ro.ubb.catalog.client.command.book_command;

import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.client.command.Command;
import ro.ubb.catalog.web.converter.BookConverter;
import ro.ubb.catalog.web.dto.BooksDto;

public class ListBooksCommand extends Command {
    @Override
    public String getName() {
        return "List all Books";
    }

    @Override
    public void run(RestTemplate restTemplate, BookConverter bookConverter) {
        try {
            BooksDto dto = restTemplate.getForObject("http://localhost:8080/api/books", BooksDto.class);

            if (dto != null) {
                dto.getBooks().forEach(x -> {
                    System.out.println(bookConverter.convertDtoToModel(x));
                });
            } else {
                System.err.println("No books found. Try adding some.");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
