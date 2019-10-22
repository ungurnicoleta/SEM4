package UI;

import Service.BookServiceClient;
import Service.ClientService;
import Service.ClientServiceClient;
import Service.ServiceException;
import UI.Command.BookCommand.*;
import UI.Command.ClientCommand.AddClientCommand;
import UI.Command.Command;
import UI.Command.ExitCommand;
import Validator.ValidatorException;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private BookServiceClient bookService;
    private ClientServiceClient clientService;

    private final HashMap<Integer, Command> commands = new HashMap<Integer, Command>() {{
        put(0, new ExitCommand());

        put(1, new AddBookCommand());
        put(2, new UpdateBookCommand());
        put(3, new RemoveBookCommand());
        put(4, new ListPagedBooksCommand());
        put(5, new ListBooksCommand());
        put(6, new FilterBooksCommand());
        put(7, new TopBooksCommand());

        put(8, new AddClientCommand());

    }};

    public Console(BookServiceClient bookService, ClientServiceClient clientService) {
        this.bookService = bookService;
        this.clientService = clientService;
    }

    private void showMenu() {
        commands.forEach((key, value) -> System.out.println(String.format("%d. %s", key, value.getName())));
    }

    /**
     * The loop() method displays the text-based UI and handles user input
     */
    public void loop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print(">>");

            while (!scanner.hasNextInt()) {
                System.err.println("Invalid input: Command is a number. Please try again.");
                System.err.print(">>");
                scanner.next();
            }

            int commandIndex = scanner.nextInt();

            if (commandIndex == 0) {
                System.out.println("Goodbye.");
                break;
            }

            Command cmd = commands.get(commandIndex);
            if (cmd == null) {
                System.err.println("Command not implemented.");
                continue;
            }

            try {
                cmd.run(bookService, clientService);
            } catch (ValidatorException | ServiceException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
