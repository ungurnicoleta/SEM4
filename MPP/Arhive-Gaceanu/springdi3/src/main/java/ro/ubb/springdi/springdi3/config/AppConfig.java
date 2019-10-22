package ro.ubb.springdi.springdi3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ro.ubb.springdi.springdi3.repository.StudentRepository;
import ro.ubb.springdi.springdi3.repository.StudentRepositoryImpl;
import ro.ubb.springdi.springdi3.service.StudentService;
import ro.ubb.springdi.springdi3.service.StudentServiceImpl;
import ro.ubb.springdi.springdi3.ui.Console;

/**
 * author: radu
 */
@Configuration
@ComponentScan({"ro.ubb.springdi.springdi3.ui",
                "ro.ubb.springdi.springdi3.service",
                "ro.ubb.springdi.springdi3.repository"})
public class AppConfig {
//    @Bean
//    Console console() {
//        return new Console();
//    }
//
//    @Bean
//    StudentService studentService() {
//        return new StudentServiceImpl();
//    }
//
//    @Bean
//    StudentRepository studentRepository() {
//        return new StudentRepositoryImpl();
//    }
}
