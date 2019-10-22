package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Entity;

/**
 * author: radu
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Student extends BaseEntity<Long> {
    private String name;
    private int grade;
}
