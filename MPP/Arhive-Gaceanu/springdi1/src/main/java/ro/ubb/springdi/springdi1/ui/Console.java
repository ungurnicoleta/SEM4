package ro.ubb.springdi.springdi1.ui;

import ro.ubb.springdi.springdi1.service.StudentService;

/**
 * author: radu
 */
public class Console {
    private StudentService studentService;

    public Console(StudentService studentService) {
        this.studentService = studentService;
    }

    public void run() {
        studentService.getAllStudents()
                      .forEach(System.out::println);
    }
}
