package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Entity;

/**
 * author: radu
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Discipline extends BaseEntity<Long> {
    private String title;

    @Override
    public String toString() {
        return "Discipline{" +
               "title='" + title + '\'' +
               "} " + super.toString();
    }
}
