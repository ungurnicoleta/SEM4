package UI.Command.BookCommand;


import Domain.Book;
import Service.BookServiceClient;
import Service.ClientServiceClient;

import java.util.concurrent.CompletableFuture;

public class UpdateBookCommand extends BookCommand {

    @Override
    public String getName() {
        return "Update Book";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        Book book = this.readBook();

        if (book == null) {
            System.err.println("Book data was not input correctly for update.");
            return;
        }

        CompletableFuture.supplyAsync(() -> {
            bookService.update(book);
            return "Updated book.";
        }).thenAccept(System.err::println);
    }
}
