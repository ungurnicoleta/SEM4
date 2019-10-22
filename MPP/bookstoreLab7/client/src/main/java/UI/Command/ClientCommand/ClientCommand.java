package UI.Command.ClientCommand;

import Domain.Book;
import Domain.Client;
import UI.Command.Command;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The BookCommand class extends Command.
 * <p>
 * It contains a common body of methods used by all CRUD operations on Book objects
 */
public abstract class ClientCommand extends Command {

    /**
     * Create a Book instance with user-given data from {@code System.in}.
     *
     * @return the relevant Book object, or null in case the user input is invalid
     */
    protected Client readClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Client: ID, Name, Age, pocketMoney, Profession");

        try {
            System.out.print("ID:");
            Long id = Long.valueOf(scanner.nextLine());

            System.out.print("Name:");
            String name = scanner.nextLine();

            System.out.print("Quantity:");
            Integer age = Integer.valueOf(scanner.nextLine());

            System.out.print("pocketMoney:");
            float pocketMoney = Float.parseFloat(scanner.nextLine());

            System.out.print("Profession:");
            String profession = scanner.nextLine();



            Client client = new Client(name,age,pocketMoney,profession);
            client.setId(id);

            return client;

        } catch (NoSuchElementException | NumberFormatException e) {
            System.err.println("Invalid input.");
        }

        return null;
    }
}
