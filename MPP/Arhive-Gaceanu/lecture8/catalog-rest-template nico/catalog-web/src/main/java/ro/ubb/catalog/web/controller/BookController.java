package ro.ubb.catalog.web.controller;

import ro.ubb.catalog.core.model.Book;
import ro.ubb.catalog.core.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.catalog.web.converter.BookConverter;
import ro.ubb.catalog.web.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookConverter bookConverter;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<BookDto> getBooks() {
        log.trace("getBooks");

        List<Book> books = bookService.getAllBooks();

        log.trace("getBooks: books={}", books);

        return new ArrayList<>(bookConverter.convertModelsToDtos(books));
    }

}
