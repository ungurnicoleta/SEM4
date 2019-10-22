package ro.ubb.springdi.springdi2.ui;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.springdi.springdi2.service.StudentService;

/**
 * author: radu
 */
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
