package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Book;

import java.util.List;


public interface BookService {
    List<Book> getAllBooks();

    Book saveBook(Book book);

    Book updateBook(Long id, Book convertDtoToModel);

    void deleteBook(Long id);
}
