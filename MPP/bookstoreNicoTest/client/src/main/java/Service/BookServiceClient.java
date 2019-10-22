package Service;

import Domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


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
}