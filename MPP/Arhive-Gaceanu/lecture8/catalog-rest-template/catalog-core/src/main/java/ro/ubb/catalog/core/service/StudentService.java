package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Student;

import java.util.List;

/**
 * author: radu
 */
public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student convertDtoToModel);

    void deleteStudent(Long id);
}
