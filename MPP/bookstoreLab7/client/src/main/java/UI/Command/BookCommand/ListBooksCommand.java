package UI.Command.BookCommand;

import Service.BookServiceClient;
import Service.ClientServiceClient;
import UI.Command.Command;

import java.util.concurrent.CompletableFuture;

public class ListBooksCommand extends Command {
    @Override
    public String getName() {
        return "List all Books";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        CompletableFuture.supplyAsync(bookService::findAll)
                .thenAccept((answer) -> answer.forEach(System.err::println));
    }
}
