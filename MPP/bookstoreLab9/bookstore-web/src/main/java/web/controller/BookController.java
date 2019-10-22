package web.controller;

import core.model.Book;
import core.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.BookConverter;
import web.dto.BookDto;
import web.dto.BooksDto;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {
    private static final Logger log =
            LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookConverter bookConverter;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    BooksDto getAllBooks() {
        log.trace("getAllBooks --- method entered");

        List<Book> books = bookService.getAllBooks();
        Set<BookDto> dtos = bookConverter.convertModelsToDtos(books);
        BooksDto result = new BooksDto(dtos);

        log.trace("getAllBooks: result={}", result);

        return result;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    BookDto saveBook(@RequestBody BookDto dto) {
        log.trace("saveBook: dto={}", dto);

        Book saved = this.bookService.saveBook(
                bookConverter.convertDtoToModel(dto)
        );
        BookDto result = bookConverter.convertModelToDto(saved);

        log.trace("saveBook: result={}", result);

        return result;
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    BookDto updateBook(@PathVariable Long id,
                       @RequestBody BookDto dto) {
        log.trace("updateBook: id={}, dto={}", id, dto);

        Book update = bookService.updateBook(
                id,
                bookConverter.convertDtoToModel(dto));
        BookDto result = bookConverter.convertModelToDto(update);

        return result;
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteBook(@PathVariable Long id) {
        log.trace("deleteStudent: id={}", id);

        bookService.deleteBook(id);

        log.trace("deleteBook --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
