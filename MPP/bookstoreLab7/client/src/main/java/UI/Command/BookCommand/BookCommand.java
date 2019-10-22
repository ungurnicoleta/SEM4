package UI.Command.BookCommand;

import Domain.Book;
import UI.Command.Command;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The BookCommand class extends Command.
 * <p>
 * It contains a common body of methods used by all CRUD operations on Book objects
 */
public abstract class BookCommand extends Command {

    /**
     * Create a Book instance with user-given data from {@code System.in}.
     *
     * @return the relevant Book object, or null in case the user input is invalid
     */
    protected Book readBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book: ID, Author, Title, ISBN, Price, Quantity");

        try {
            System.out.print("ID:");
            Long id = Long.valueOf(scanner.nextLine());

            System.out.print("Author:");
            String author = scanner.nextLine();

            System.out.print("Title:");
            String title = scanner.nextLine();

            System.out.print("ISBN:");
            String ISBN = scanner.nextLine();

            System.out.print("Price:");
            float price = Float.parseFloat(scanner.nextLine());

            System.out.print("Quantity:");
            Integer quantity = Integer.valueOf(scanner.nextLine());

            Book book = new Book(author, title, ISBN, price, quantity);
            book.setId(id);

            return book;

        } catch (NoSuchElementException | NumberFormatException e) {
            System.err.println("Invalid input.");
        }

        return null;
    }
}
