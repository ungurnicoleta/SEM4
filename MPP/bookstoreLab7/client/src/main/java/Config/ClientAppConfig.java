package Config;

import Domain.Client;
import Service.BookService;
import Service.BookServiceClient;
import Service.ClientService;
import Service.ClientServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;


@Configuration
public class ClientAppConfig {

    @Bean
    BookServiceClient bookServiceClient() {
        return new BookServiceClient();
    }

    @Bean
    ClientServiceClient clientServiceClient() {
        return new ClientServiceClient();
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(BookService.class);
        rmiProxyFactoryBean
                .setServiceUrl("rmi://localhost:1099/BookService");
        return rmiProxyFactoryBean;
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBeanClient() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(ClientService.class);
        rmiProxyFactoryBean
                .setServiceUrl("rmi://localhost:1099/ClientService");
        return rmiProxyFactoryBean;
    }
}