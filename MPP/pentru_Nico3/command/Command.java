package ro.ubb.catalog.client.command;

import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.converter.BookConverter;

public abstract class Command {

    public abstract String getName();

    public abstract void run(RestTemplate restTemplate, BookConverter bookConverter);
}
