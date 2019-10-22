package Config;

import Domain.Book;
import Domain.Client;
import Repository.*;
import Service.BookService;
import Service.BookServiceImpl;
import Service.ClientService;
import Service.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class ServerAppConfig {
    @Bean
    RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("BookService");
        exporter.setServiceInterface(BookService.class);
        exporter.setService(bookService());
        return exporter;
    }

    @Bean
    RmiServiceExporter rmiServiceExporterClient() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("ClientService");
        exporter.setServiceInterface(ClientService.class);
        exporter.setService(clientService());
        return exporter;
    }

    @Bean
    BookRepositoryImpl bookRepository() {
        return new BookRepositoryImpl();
    }

    @Bean
    Repository<Client> clientRepository() {
        return new ClientRepositoryImpl();
    }

    @Bean
    BookService bookService() {
        return new BookServiceImpl();
    }

    @Bean
    ClientService clientService() {
        ClientService serviceCl = new ClientServiceImpl();
        return serviceCl;
    }
}
