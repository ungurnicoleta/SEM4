package ro.ubb.springdi.springdi2.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.springdi.springdi2.model.Student;
import ro.ubb.springdi.springdi2.repository.StudentRepository;

import java.util.List;

/**
 * author: radu
 */
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    public StudentServiceImpl(
//            StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
