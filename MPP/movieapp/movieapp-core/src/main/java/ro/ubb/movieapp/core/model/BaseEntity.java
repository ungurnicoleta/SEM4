package ro.ubb.movieapp.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Data
public abstract class BaseEntity<ID extends Serializable>
        implements Serializable {

    @Id
    @GeneratedValue
    private ID id;

}
