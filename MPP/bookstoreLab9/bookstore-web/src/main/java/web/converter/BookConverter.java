package web.converter;

import core.model.Book;
import org.springframework.stereotype.Component;
import web.dto.BookDto;

@Component
public class BookConverter extends BaseConverter<Book, BookDto> {
    @Override
    public Book convertDtoToModel(BookDto dto) {
        Book book = Book.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .ISBN(dto.getISBN())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
        book.setId(dto.getId());
        return book;
    }

    @Override
    public BookDto convertModelToDto(Book book) {
        BookDto dto = BookDto.builder()
                .author(book.getAuthor())
                .title(book.getTitle())
                .ISBN(book.getISBN())
                .price(book.getPrice())
                .quantity(book.getQuantity())
                .build();
        dto.setId(book.getId());
        return dto;
    }
}
