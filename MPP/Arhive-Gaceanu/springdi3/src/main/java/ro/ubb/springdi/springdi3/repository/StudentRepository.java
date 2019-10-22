package ro.ubb.springdi.springdi3.repository;

import ro.ubb.springdi.springdi3.model.Student;

import java.util.List;

/**
 * author: radu
 */
public interface StudentRepository {
    List<Student> findAll();
}
