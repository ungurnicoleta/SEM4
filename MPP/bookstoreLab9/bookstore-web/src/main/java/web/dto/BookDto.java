package web.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class BookDto extends BaseDto {
    private String author;
    private String title;
    private String ISBN;
    private float price;
    private Integer quantity;

}
