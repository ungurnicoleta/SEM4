package ro.ubb.catalog.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.client.command.Command;
import ro.ubb.catalog.client.command.ExitCommand;
import ro.ubb.catalog.client.command.book_command.*;
import ro.ubb.catalog.web.converter.BookConverter;
import ro.ubb.catalog.web.dto.BookDto;

import java.util.HashMap;
import java.util.Scanner;

@Component
public class Console {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookConverter bookConverter;

    private final HashMap<Integer, Command> commands = new HashMap<>() {{
        put(0, new ExitCommand());
        put(1, new ListBooksCommand());
        put(2, new AddBookCommand());
        put(3, new RemoveBookCommand());
        put(4, new UpdateBookCommand());
    }};

    private void showMenu() {
        commands.forEach((key, value) -> System.out.println(String.format("%d. %s", key, value.getName())));
    }

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
                System.out.println("Bye.");
                break;
            }

            Command cmd = commands.get(commandIndex);
            if (cmd == null) {
                System.err.println("Command not implemented.");
                continue;
            }

            cmd.run(restTemplate, bookConverter);
        }

    }

}
