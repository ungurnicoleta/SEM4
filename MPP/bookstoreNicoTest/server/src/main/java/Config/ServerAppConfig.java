package Config;

import Repository.BookRepository;
import Repository.BookRepositoryImpl;
import Service.BookService;
import Service.BookServiceImpl;
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
    BookRepository bookRepository() {
        return new BookRepositoryImpl();
    }

    @Bean
    BookService bookService() {
        BookService service = new BookServiceImpl(bookRepository());
        return service;
    }
}
