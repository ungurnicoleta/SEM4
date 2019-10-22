package ro.ubb.springjpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.springjpa.model.Student;
import ro.ubb.springjpa.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * author: radu
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(
            StudentServiceImpl.class);

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
    public void saveStudent(Student student) {
        log.trace("saveStudent: student={}", student);

        studentRepository.save(student);

        log.trace("saveStudent --- method finished");
    }

    @Override
    @Transactional
    public void update(Student student) {
        log.trace("update: student={}", student);

        studentRepository.findById(student.getId())
                         .ifPresent(student1 -> {
                             student1.setName(student.getName());
                             student1.setGrade(student.getGrade());
                             log.debug("update --- student updated? --- " +
                                       "student={}", student1);
                         });

        log.trace("update --- method finished");
    }

    @Override
    public void delete(Long id) {
        log.trace("delete: id={}", id);

        studentRepository.deleteById(id);

        log.trace("delete --- method finished");
    }
}
