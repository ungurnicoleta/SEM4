package Service;

import Domain.Book;
import Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        this.bookRepository.update(book);
    }
}
