package ro.ubb.movieapp.web.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductionHouseDto extends BaseDto{
    private String name;
    private List<MovieDto> movies;
}
