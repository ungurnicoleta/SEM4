package ro.ubb.springdi.springdi2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ubb.springdi.springdi2.repository.StudentRepository;
import ro.ubb.springdi.springdi2.repository.StudentRepositoryImpl;
import ro.ubb.springdi.springdi2.service.StudentService;
import ro.ubb.springdi.springdi2.service.StudentServiceImpl;
import ro.ubb.springdi.springdi2.ui.Console;

/**
 * author: radu
 */
@Configuration
public class AppConfig {
    @Bean
    Console console() {
        return new Console();
    }

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }
}
