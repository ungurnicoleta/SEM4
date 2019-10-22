package ro.ubb.catalog.client.command.book_command;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.converter.BookConverter;
import ro.ubb.catalog.web.dto.BookDto;

public class UpdateBookCommand extends BookCommand {

    @Override
    public String getName() {
        return "Update Book";
    }

    @Override
    public void run(RestTemplate restTemplate, BookConverter bookConverter) {
        BookDto book = this.readBook();

        if (book == null) {
            System.err.println("Book data was not input correctly for update.");
            return;
        }

        try {
            restTemplate.put("http://localhost:8080/api/books/{bookId}", book.getId(), book);
        } catch (HttpClientErrorException httpClientErrorException) {
            System.err.println(httpClientErrorException.getMessage());
        }
    }
}
