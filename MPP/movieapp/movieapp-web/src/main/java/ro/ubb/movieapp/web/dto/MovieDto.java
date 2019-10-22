package ro.ubb.movieapp.web.dto;


import lombok.*;
import ro.ubb.movieapp.core.model.ProductionHouse;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MovieDto extends BaseDto {
    private String title;
    private String description;
    private String productionHouse;
}
