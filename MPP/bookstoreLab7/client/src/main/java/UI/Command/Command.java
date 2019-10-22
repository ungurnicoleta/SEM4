package UI.Command;

import Service.BookServiceClient;
import Service.ClientServiceClient;

public abstract class Command {

    public abstract String getName();

    public abstract void run(BookServiceClient service, ClientServiceClient clientService);

}
