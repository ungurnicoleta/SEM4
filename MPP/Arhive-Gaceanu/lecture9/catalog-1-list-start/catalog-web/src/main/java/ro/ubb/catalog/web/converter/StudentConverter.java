package ro.ubb.catalog.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.web.dto.StudentDto;

/**
 * Created by radu.
 */

@Component
public class StudentConverter extends BaseConverter<Student, StudentDto> {

    private static final Logger log = LoggerFactory.getLogger(StudentConverter.class);

    @Override
    public Student convertDtoToModel(StudentDto dto) {
        throw new RuntimeException("Not yet implemented!");
    }

    @Override
    public StudentDto convertModelToDto(Student student) {
        StudentDto studentDto = new StudentDto(student.getSerialNumber(),
                student.getName(), student.getGroupNumber());
        studentDto.setId(student.getId());
        return studentDto;
    }
}
