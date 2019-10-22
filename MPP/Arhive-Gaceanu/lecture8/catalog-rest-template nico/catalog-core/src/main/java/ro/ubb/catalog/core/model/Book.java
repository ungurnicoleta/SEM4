package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Getter
public class Book extends BaseEntity<Long> {
    private String author;
    private String title;
    private String ISBN;
    private float price;
    private Integer quantity;
}

