package ro.ubb.catalog.web.converter;

import ro.ubb.catalog.core.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.web.dto.BookDto;

@Component
public class BookConverter extends BaseConverter<Book, BookDto> {

    private static final Logger log = LoggerFactory.getLogger(BookConverter.class);

    @Override
    public Book convertDtoToModel(BookDto dto) {
        Book book = new Book(dto.getAuthor(), dto.getTitle(), dto.getISBN(),
                dto.getPrice(), dto.getQuantity());
        book.setId(dto.getId());
        return book;
    }

    @Override
    public BookDto convertModelToDto(Book book) {
        BookDto bookDto = new BookDto(book.getAuthor(), book.getTitle(), book.getISBN(),
                book.getPrice(), book.getQuantity());
        bookDto.setId(book.getId());
        return bookDto;
    }
}
