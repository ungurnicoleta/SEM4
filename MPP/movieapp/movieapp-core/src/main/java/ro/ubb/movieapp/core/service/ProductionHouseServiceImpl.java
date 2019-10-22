package ro.ubb.movieapp.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.movieapp.core.model.Actor;
import ro.ubb.movieapp.core.model.JobApplication;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.repository.ActorRepository;
//import ro.ubb.movieapp.core.repository.JobRepository;
import ro.ubb.movieapp.core.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

/**
 * author: radu
 */

@Service
public class ProductionHouseServiceImpl implements ProductionHouseService {
    private final MovieRepository movieRepository;
//    private final ActorRepository actorRepository;
//    private final JobRepository jobRepository;

    @Autowired
    public ProductionHouseServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
//        this.jobRepository = jobRepository;
//        this.actorRepository = actorRepository;
    }


    @Override
    public List<Movie> getMovies(String productionHouse) {
        return this.movieRepository.getMoviesByProductionHouse(productionHouse);
    }


//    @Override
//    public Actor findActor(String email){
//        return this.actorRepository.findByEmail(email);
//    }
//
//
//    @Override
//    public void saveJobApplication(Long movieID, Long actorId, String latestMovie) {
//        Optional<Movie> movieNew = this.movieRepository.findById(movieID);
//        Optional<Actor> actorNew = this.actorRepository.findById(actorId);
//        if (movieNew.isPresent() && actorNew.isPresent()) {
//            Movie mov = movieNew.get();
//            Actor act = actorNew.get();
//            JobApplication job = JobApplication.builder().movie(mov).actor(act).latestMovie(latestMovie).build();
//
//            this.jobRepository.save(job);
//        }
//    }
//
//    @Override
//    public List<JobApplication> findAllJobs() {
//        return this.jobRepository.findAllJobs();
//    }
}
