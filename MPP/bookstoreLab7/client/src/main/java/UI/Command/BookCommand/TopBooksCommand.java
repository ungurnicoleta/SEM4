package UI.Command.BookCommand;

import Service.BookServiceClient;
import Service.ClientServiceClient;
import UI.Command.Command;

import java.util.Scanner;

public class TopBooksCommand extends Command {
    @Override
    public String getName() {
        return "Top N Books";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        System.out.println("Top Books");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Top number:");
        String number = scanner.nextLine();

        bookService.topBooksByPrice(Integer.parseInt(number)).forEach(System.err::println);
    }
}
