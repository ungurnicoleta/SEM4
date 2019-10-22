package ro.ubb.catalog.client.command.book_command;

import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.converter.BookConverter;
import ro.ubb.catalog.web.dto.BookDto;

public class AddBookCommand extends BookCommand {

    @Override
    public String getName() {
        return "Add Book.";
    }

    @Override
    public void run(RestTemplate restTemplate, BookConverter bookConverter) {
        BookDto bookDto = this.readBook();
        restTemplate.postForObject("http://localhost:8080/api/books", bookDto, BookDto.class);
    }
}
