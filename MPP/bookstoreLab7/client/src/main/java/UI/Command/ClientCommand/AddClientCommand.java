package UI.Command.ClientCommand;

import Domain.Client;
import Service.BookServiceClient;
import Service.ClientServiceClient;


import java.util.concurrent.CompletableFuture;

public class AddClientCommand extends ClientCommand {

    @Override
    public String getName() {
        return "Add Client";
    }

    @Override
    public void run(BookServiceClient service, ClientServiceClient clientService) {
        Client client = this.readClient();

        if (client == null) {
            System.err.println("Client data was not input correctly.");
            return;
        }

        CompletableFuture.supplyAsync(() -> {
            clientService.add(client);
            return "Added client.";
        }).thenAccept(System.err::println);
    }
}
