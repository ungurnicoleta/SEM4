package ro.ubb.movieapp.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ActorDto extends BaseDto {
    private String email;
    private String name;
    private String address;
}
