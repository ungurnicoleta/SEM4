package ro.ubb.springdi.springdi3.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.springdi.springdi3.service.StudentService;

/**
 * author: radu
 */
@Component
public class Console {
    @Autowired
    private StudentService studentService;

//    public Console(StudentService studentService) {
//        this.studentService = studentService;
//    }

    public void run() {
        studentService.getAllStudents()
                      .forEach(System.out::println);
    }
}
