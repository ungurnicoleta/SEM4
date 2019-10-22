package ro.ubb.springdi.springdi3.repository;

import org.springframework.stereotype.Repository;
import ro.ubb.springdi.springdi3.model.Student;

import java.util.Arrays;
import java.util.List;

/**
 * author: radu
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        return Arrays.asList(
                new Student(1l, "s1", 10),
                new Student(2l, "s2", 10)
        );
    }
}
