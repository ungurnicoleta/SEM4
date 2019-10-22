package UI.Command;

import Service.BookServiceClient;
import Service.ClientServiceClient;

public class ExitCommand extends Command {

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void run(BookServiceClient bookService, ClientServiceClient clientService) {
        // Do nothing, just exit...
    }
}
