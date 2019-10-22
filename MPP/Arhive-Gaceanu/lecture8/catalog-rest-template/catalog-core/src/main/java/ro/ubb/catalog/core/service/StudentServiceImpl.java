package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

/**
 * author: radu
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log =
            LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        log.trace("getAllStudents --- method entered");

        List<Student> result = studentRepository.findAll();

        log.trace("getAllStudents: result={}", result);

        return result;
    }

    @Override
    public Student saveStudent(Student student) {
        log.trace("-----saveStudent------ student={}", student);

        Student savedStudent = this.studentRepository.save(student);

        //todo log result...

        return savedStudent;
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, Student student) {
        log.trace("updateStudent: id={},student={}", id, student);

        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student result = optionalStudent.orElse(student);
        result.setName(student.getName());
        result.setGrade(student.getGrade());

        log.trace("updateStudent: result={}", result);

        return result;
    }

    @Override
    public void deleteStudent(Long id) {
        log.trace("deleteStudent: id={}", id);

        studentRepository.deleteById(id);

        log.trace("deleteStudent --- method finished");
    }


}
