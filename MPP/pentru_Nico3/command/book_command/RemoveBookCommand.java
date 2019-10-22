package ro.ubb.catalog.client.command.book_command;

import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.client.command.Command;
import ro.ubb.catalog.web.converter.BookConverter;

import java.util.Scanner;

public class RemoveBookCommand extends Command {
    @Override
    public String getName() {
        return "Remove Book";
    }

    @Override
    public void run(RestTemplate restTemplate, BookConverter bookConverter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The ID of the book to be deleted: ");
        Long id = Long.valueOf(scanner.nextLine());

        try {
            restTemplate.delete("http://localhost:8080/api/books/{bookId}", id);
            System.out.println(String.format("Removed book #%d.", id));
        } catch (HttpServerErrorException httpServerErrorException) {
            System.err.println(httpServerErrorException.getMessage());
        }
    }
}
