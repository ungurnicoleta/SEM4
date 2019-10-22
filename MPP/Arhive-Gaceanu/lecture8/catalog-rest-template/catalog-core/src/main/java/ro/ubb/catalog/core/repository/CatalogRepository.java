package ro.ubb.catalog.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.catalog.core.model.BaseEntity;

import java.io.Serializable;

/**
 * author: radu
 */
public interface CatalogRepository<T extends BaseEntity<ID>,
        ID extends Serializable>
        extends JpaRepository<T, ID> {
}
