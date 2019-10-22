package UI.Command.BookCommand;

import Domain.Book;
import Service.BookServiceClient;
import Service.ClientServiceClient;

import java.util.concurrent.CompletableFuture;

public class AddBookCommand extends BookCommand {

    @Override
    public String getName() {
        return "Add Book";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        Book book = this.readBook();

        if (book == null) {
            System.err.println("Book data was not input correctly.");
            return;
        }

        CompletableFuture.supplyAsync(() -> {
            bookService.add(book);
            return "Added book.";
        }).thenAccept(System.err::println);
    }
}
