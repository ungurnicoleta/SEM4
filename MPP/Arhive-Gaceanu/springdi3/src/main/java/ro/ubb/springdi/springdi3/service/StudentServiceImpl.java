package ro.ubb.springdi.springdi3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.springdi.springdi3.model.Student;
import ro.ubb.springdi.springdi3.repository.StudentRepository;

import java.util.List;

/**
 * author: radu
 */
@Service
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
