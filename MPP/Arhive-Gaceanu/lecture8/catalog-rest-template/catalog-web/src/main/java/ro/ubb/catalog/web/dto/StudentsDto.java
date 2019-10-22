package ro.ubb.catalog.web.dto;

import lombok.*;

import java.util.Set;

/**
 * author: radu
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentsDto {
    private Set<StudentDto> students;


}
