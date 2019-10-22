package ro.ubb.springdi.springdi1.repository;

import ro.ubb.springdi.springdi1.model.Student;

import java.util.List;

/**
 * author: radu
 */
public interface StudentRepository {
    List<Student> findAll();
}
