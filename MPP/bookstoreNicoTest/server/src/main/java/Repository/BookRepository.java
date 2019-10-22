package Repository;

import Domain.Book;

import java.util.List;


public interface BookRepository {
    List<Book> findAll();

    void save(Book book);

    void update(Book book);

    void deleteById(Long id);
}
