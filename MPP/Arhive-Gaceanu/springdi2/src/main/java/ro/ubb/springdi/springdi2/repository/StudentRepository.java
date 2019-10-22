package ro.ubb.springdi.springdi2.repository;

import ro.ubb.springdi.springdi2.model.Student;

import java.util.List;

/**
 * author: radu
 */
public interface StudentRepository {
    List<Student> findAll();
}
