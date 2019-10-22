package Service;

import Domain.Book;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryImpl repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Book book) {
        this.repository.save(book);
    }

    @Override
    public void remove(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        this.repository.update(book);
    }

    /**
     * Finds all books containing the given substring {@code keyword} in the title.
     *
     * @param keyword the searched substring
     * @return a set of Book objects
     */
    @Override
    public Set<Book> filterBooksByTitle(String keyword) {
        List<Book> allBooks = this.repository.findAll();

        Set<Book> filteredBooks = new HashSet<>(allBooks);
        filteredBooks.removeIf(book -> !book.getTitle().toLowerCase().contains(keyword.toLowerCase()));

        return filteredBooks;
    }

    /**
     * Find the first (number) most expensive books
     *
     * @param number the searched substring
     * @return a set of Book objects
     */
    @Override
    public Set<Book> topBooksByPrice(Integer number) {
        List<Book> allBooks = this.repository.findAll();

        Set<Book> topBooks = new HashSet<>(allBooks);
        return topBooks.stream()
                .sorted(comparing(Book::getPrice, comparing(Math::abs))
                        .reversed())
                .limit(number)
                .collect(Collectors.toSet());
    }


}
