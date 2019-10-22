package ro.ubb.catalog.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.dto.StudentDto;
import ro.ubb.catalog.web.dto.StudentsDto;

/**
 * Created by radu.
 */
public class ClientApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.catalog.client.config"
                );

        RestTemplate restTemplate = context.getBean(RestTemplate.class);


        StudentDto newStudent = StudentDto.builder()
                                          .name("sNEW")
                                          .grade(5)
                                          .build();
        StudentDto savedStudent = restTemplate.postForObject(
                "http://localhost:8080/api/students",
                newStudent,
                StudentDto.class
        );

//        savedStudent.setGrade(2);
//        restTemplate.put(
//                "http://localhost:8080/api/students/{id}",
//                savedStudent,
//                savedStudent.getId()
//        );
//
//        restTemplate.delete(
//                "http://localhost:8080/api/students/{id}",
//                savedStudent.getId()
//        );
//
//        StudentsDto studentsDto = restTemplate.getForObject(
//                "http://localhost:8080/api/students",
//                StudentsDto.class
//        );
//        System.out.println(studentsDto);

        System.out.println("bye ");
    }
}
