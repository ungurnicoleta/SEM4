package ro.ubb.springdi.springdi1.service;

import ro.ubb.springdi.springdi1.model.Student;
import ro.ubb.springdi.springdi1.repository.StudentRepository;

import java.util.Arrays;
import java.util.List;

/**
 * author: radu
 */
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(
            StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
