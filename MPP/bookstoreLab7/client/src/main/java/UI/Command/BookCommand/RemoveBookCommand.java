package UI.Command.BookCommand;

import Service.BookServiceClient;
import Service.ClientServiceClient;
import UI.Command.Command;

import java.util.Scanner;

public class RemoveBookCommand extends Command {
    @Override
    public String getName() {
        return "Remove Book";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        Scanner scanner = new Scanner(System.in);
        System.err.print("The ID of the book to be deleted: ");
        Long ID = Long.valueOf(scanner.nextLine());
        bookService.remove(ID);
    }
}
