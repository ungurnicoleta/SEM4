package ro.ubb.springjpa.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.springjpa.model.Student;
import ro.ubb.springjpa.service.StudentService;

/**
 * author: radu
 */
@Component
public class Console {
    @Autowired
    private StudentService studentService;

    public void run() {
        //save
        Student student = new Student("save", 9);
        studentService.saveStudent(student);

        printAllStudents();

        Student update = studentService.getAllStudents().get(0);
        update.setName("update");
        studentService.update(update);
        printAllStudents();

//        Long deleteId = studentService.getAllStudents().get(0).getId();
//        studentService.delete(deleteId);
//        printAllStudents();
    }

    private void printAllStudents() {
        studentService.getAllStudents()
                      .forEach(System.out::println);
    }
}
