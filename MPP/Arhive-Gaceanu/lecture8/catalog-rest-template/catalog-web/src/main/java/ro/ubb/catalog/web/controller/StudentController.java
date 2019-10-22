package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.service.StudentService;
import ro.ubb.catalog.web.converter.StudentConverter;
import ro.ubb.catalog.web.dto.StudentDto;
import ro.ubb.catalog.web.dto.StudentsDto;

import java.util.List;
import java.util.Set;

/**
 * author: radu
 */

@RestController
public class StudentController {
    private static final Logger log =
            LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentConverter studentConverter;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    StudentsDto getAllStudents() {
        log.trace("getAllStudents --- method entered");

        List<Student> students = studentService.getAllStudents();
        Set<StudentDto> dtos = studentConverter.convertModelsToDtos(students);
        StudentsDto result = new StudentsDto(dtos);

        log.trace("getAllStudents: result={}", result);

        return result;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    StudentDto saveStudent(@RequestBody StudentDto dto) {
        log.trace("saveStudent: dto={}", dto);

        Student saved = this.studentService.saveStudent(
                studentConverter.convertDtoToModel(dto)
        );
        StudentDto result = studentConverter.convertModelToDto(saved);

        log.trace("saveStudent: result={}", result);

        return result;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    StudentDto updateStudent(@PathVariable Long id,
            @RequestBody StudentDto dto) {
        log.trace("updateStudent: id={},dto={}", id, dto);

        Student update = studentService.updateStudent(
                id,
                studentConverter.convertDtoToModel(dto));
        StudentDto result = studentConverter.convertModelToDto(update);

        return result;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        log.trace("deleteStudent: id={}", id);

        studentService.deleteStudent(id);

        log.trace("deleteStudent --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
