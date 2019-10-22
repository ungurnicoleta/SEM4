package ro.ubb.movieapp.core.service;

import ro.ubb.movieapp.core.model.Actor;
import ro.ubb.movieapp.core.model.JobApplication;
import ro.ubb.movieapp.core.model.Movie;

import java.util.List;

/**
 * author: radu
 */
public interface ProductionHouseService {
    List<Movie> getMovies(String productionHouse);

//    Actor findActor(String email);
//
//    void saveJobApplication(Long movieID, Long actorId, String latestMovie);
//
//    List<JobApplication> findAllJobs();

}
