package Repository;

import Domain.BaseEntity;
import Domain.Book;

import java.util.List;


public interface Repository <T extends BaseEntity<Long>> {
    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void deleteById(Long id);
}
