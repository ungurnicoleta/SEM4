package ro.ubb.springdi.springdi1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ubb.springdi.springdi1.repository.StudentRepository;
import ro.ubb.springdi.springdi1.repository.StudentRepositoryImpl;
import ro.ubb.springdi.springdi1.service.StudentService;
import ro.ubb.springdi.springdi1.service.StudentServiceImpl;
import ro.ubb.springdi.springdi1.ui.Console;
import sun.swing.CachedPainter;

/**
 * author: radu
 */
@Configuration
public class AppConfig {
    @Bean
    Console console() {
        return new Console(studentService());
    }

    private StudentService studentService() {
        return new StudentServiceImpl(studentRepository());
    }

    private StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }
}
