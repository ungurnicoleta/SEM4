package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookDto extends BaseDto {
    private String author;
    private String title;
    private String ISBN;
    private float price;
    private Integer quantity;

    @Override
    public String toString() {
        return String.format("BookDto{%s, %s, %s, %f, %d}", author, title, ISBN, price, quantity);
    }
}
