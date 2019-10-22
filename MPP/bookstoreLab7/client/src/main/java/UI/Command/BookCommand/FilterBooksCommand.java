package UI.Command.BookCommand;

import Service.BookServiceClient;
import Service.ClientServiceClient;
import UI.Command.Command;

import java.util.Scanner;

public class FilterBooksCommand extends Command {
    @Override
    public String getName() {
        return "Filter Books by Title";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        System.out.println("Filter Books");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Title contains:");
        String keyword = scanner.nextLine();

        bookService.filterBooksByTitle(keyword).forEach(System.err::println);
    }
}
