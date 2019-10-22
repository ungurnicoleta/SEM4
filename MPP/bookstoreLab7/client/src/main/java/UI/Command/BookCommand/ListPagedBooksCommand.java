package UI.Command.BookCommand;

import Service.BookService;
import Service.BookServiceClient;
import Service.ClientServiceClient;
import UI.Command.Command;

import java.util.Scanner;

public class ListPagedBooksCommand extends Command {
    @Override
    public String getName() {
        return "See Books Page by Page";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showCurrentPage(bookService);
            showMenu();
            System.out.print(">>");

            while (!scanner.hasNext()) {
                System.err.println("Invalid input.");
                System.err.print(">>");
                scanner.next();
            }

            String line = scanner.nextLine();
            line = line.trim();

            if (line.equalsIgnoreCase("x")) {
                return;
            } else if (line.equalsIgnoreCase("n")) {
                showNextPage(bookService);
            } else if (line.equalsIgnoreCase("p")) {
                showPrevPage(bookService);
            } else {
                System.err.println("Command not implemented.");
            }
        }
    }

    private void showCurrentPage(BookService bookService) {
//        System.out.println(String.format("Page: %d / %d", bookService.getPageNumber(), bookService.getTotalPages()));
//        bookService.getCurrentPage().forEach(System.out::println);
    }

    private void showMenu() {
        System.out.println("[p] Previous [x] Exit [n] Next");
    }

    private void showNextPage(BookService bookService) {
//        bookService.getNextPage();
    }

    private void showPrevPage(BookService bookService) {
//        bookService.getPrevPage();
    }

}
