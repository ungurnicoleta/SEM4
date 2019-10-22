package ro.ubb.catalog.core.repository;


import org.springframework.stereotype.Repository;
import ro.ubb.catalog.core.model.Book;

@Repository
public interface BookRepository extends LibraryRepository<Book, Long> {
}
