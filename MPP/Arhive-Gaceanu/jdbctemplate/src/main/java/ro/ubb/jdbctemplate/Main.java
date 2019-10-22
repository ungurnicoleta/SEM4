package ro.ubb.jdbctemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.jdbctemplate.repository.StudentRepository;

/**
 * author: radu
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.jdbctemplate.config"
                );

        StudentRepository studentRepository =
                (StudentRepository) context.getBean(
                        "studentRepository");

        studentRepository.findAll()
                         .forEach(student -> System.out.println(student));


        System.out.println("bye");
    }
}
