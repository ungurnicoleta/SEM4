package core.repository;

import core.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface LibraryRepository<T extends BaseEntity<ID>,
        ID extends Serializable>
        extends JpaRepository<T, ID> {
}