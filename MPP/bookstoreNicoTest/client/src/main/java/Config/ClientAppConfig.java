package Config;

import Service.BookService;
import Service.BookServiceClient;
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
    RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(BookService.class);
        rmiProxyFactoryBean
                .setServiceUrl("rmi://localhost:1099/BookService");
        return rmiProxyFactoryBean;
    }
}