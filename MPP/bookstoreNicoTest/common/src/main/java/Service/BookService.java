package Service;

import Domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void add(Book book);

    void remove(Long id);

    void update(Book book);
}
