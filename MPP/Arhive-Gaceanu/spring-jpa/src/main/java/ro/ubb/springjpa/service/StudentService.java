package ro.ubb.springjpa.service;

import ro.ubb.springjpa.model.Student;

import java.util.List;

/**
 * author: radu
 */
public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);

    void update(Student student);

    void delete(Long id);
}
