package ro.ubb.movieapp.web.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class JobApplicationDto extends BaseDto{
    private MovieDto movieDto;
    private ActorDto actorDto;
    private String latestMovie;
}
