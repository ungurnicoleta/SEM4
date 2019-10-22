package Service;

import Domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


public class BookServiceClient implements BookService {
    @Autowired
    private BookService bookService;

    @Override
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @Override
    public void add(Book book) {
        bookService.add(book);
    }

    @Override
    public void remove(Long id) {
        bookService.remove(id);
    }

    @Override
    public void update(Book book) {
        bookService.update(book);
    }

    @Override
    public Set<Book> filterBooksByTitle(String keyword) {
        return bookService.filterBooksByTitle(keyword);
    }

    @Override
    public Set<Book> topBooksByPrice(Integer number) {
        return bookService.topBooksByPrice(number);
    }
}