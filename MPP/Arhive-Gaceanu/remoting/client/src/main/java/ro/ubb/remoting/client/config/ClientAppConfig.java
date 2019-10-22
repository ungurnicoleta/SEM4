package ro.ubb.remoting.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.ubb.remoting.client.service.StudentServiceClient;
import ro.ubb.remoting.common.StudentService;

/**
 * author: radu
 */

@Configuration
public class ClientAppConfig {

    @Bean
    StudentServiceClient studentServiceClient() {
        return new StudentServiceClient();
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
        rmiProxyFactoryBean
                .setServiceUrl("rmi://localhost:1099/StudentService");
        return rmiProxyFactoryBean;
    }
}
