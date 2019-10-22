package ro.ubb.catalog.client.command;

import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.converter.BookConverter;

public class ExitCommand extends Command {

    @Override
    public String getName() { return "Exit."; }

    @Override
    public void run(RestTemplate restTemplate, BookConverter bookConverter) {}

}
