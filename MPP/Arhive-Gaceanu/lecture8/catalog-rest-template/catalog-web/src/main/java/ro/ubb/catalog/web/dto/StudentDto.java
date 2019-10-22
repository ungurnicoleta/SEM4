package ro.ubb.catalog.web.dto;

import lombok.*;

/**
 * author: radu
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class StudentDto extends BaseDto {
    private String name;
    private int grade;
}
