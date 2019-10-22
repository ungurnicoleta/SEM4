package ro.ubb.movieapp.web.converter;

import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.model.ProductionHouse;
import ro.ubb.movieapp.web.dto.MovieDto;
import ro.ubb.movieapp.web.dto.ProductionHouseDto;

public class MovieConverter extends BaseConverter<Movie, MovieDto> {

    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = Movie.builder().title(dto.getTitle()).description(dto.getDescription()).build();
        movie.setId(dto.getId());
        return movie;
    }

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto movieDto = MovieDto.builder().title(movie.getTitle()).description(movie.getDescription()).build();
        movieDto.setId(movie.getId());
        return movieDto;
    }
}
