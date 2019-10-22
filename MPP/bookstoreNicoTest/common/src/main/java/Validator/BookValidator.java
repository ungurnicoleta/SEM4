package Validator;

import Domain.Book;

import java.util.Optional;

public class BookValidator implements Validator<Book> {
    /**
     * Function which validates a Book object.
     * @param entity represents a Book object
     * @throws ValidatorException if the book is not valid
     */
    @Override
    public void validate(Book entity) throws ValidatorException {
        Optional.ofNullable(entity.getAuthor()).filter(x ->!x.equals("")).orElseThrow(() ->
                new ValidatorException("Author's name can not be null!"));
        Optional.ofNullable(entity.getTitle()).filter(x ->!x.equals("")).orElseThrow(() ->
                new ValidatorException("You should have a title that is not null!"));
        Optional.ofNullable(entity.getISBN()).filter(x ->x.length() >= 13).orElseThrow(() ->
                new ValidatorException("ISBN must have 13 digits..."));
        Optional.ofNullable(entity.getPrice()).filter(x ->x >= 0).orElseThrow(() ->
                new ValidatorException("The price can not be a negative number!"));
        Optional.ofNullable(entity.getQuantity()).filter(x ->x >= 0).orElseThrow(() ->
                new ValidatorException("The quantity can not be negative."));
    }
}
