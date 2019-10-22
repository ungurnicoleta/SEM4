package ro.ubb.movieapp.core.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import ro.ubb.movieapp.core.model.Movie;

import java.util.List;

/**
 * author: radu
 */
public interface MovieRepository extends MovieAppRepository<Movie, Long> {
    @EntityGraph(value = "movieProductionHouse")
    List<Movie> getMoviesByProductionHouse(String productionHouse);

}
