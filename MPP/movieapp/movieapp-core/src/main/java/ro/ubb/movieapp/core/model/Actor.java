package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;


/**
 * author: radu
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "actor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Actor extends BaseEntity<Long> {
    @Column(unique=true)
    private String email;

    private String name;

    private String address;


}
