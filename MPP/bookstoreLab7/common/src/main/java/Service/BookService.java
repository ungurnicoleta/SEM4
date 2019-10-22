package Service;

import Domain.Book;

import java.util.List;
import java.util.Set;

public interface BookService {

    List<Book> findAll();

    void add(Book book);

    void remove(Long id);

    void update(Book book);

    Set<Book> filterBooksByTitle(String keyword);

    Set<Book> topBooksByPrice(Integer number);
}
