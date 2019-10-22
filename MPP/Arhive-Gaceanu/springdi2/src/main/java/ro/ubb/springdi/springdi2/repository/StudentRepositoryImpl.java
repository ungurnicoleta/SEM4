package ro.ubb.springdi.springdi2.repository;

import ro.ubb.springdi.springdi2.model.Student;

import java.util.Arrays;
import java.util.List;

/**
 * author: radu
 */
public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        return Arrays.asList(
                new Student(1l, "s1", 10),
                new Student(2l, "s2", 10)
        );
    }
}
