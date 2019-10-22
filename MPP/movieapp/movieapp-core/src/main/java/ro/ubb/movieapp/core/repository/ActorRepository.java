package ro.ubb.movieapp.core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.movieapp.core.model.Actor;


public interface ActorRepository extends MovieAppRepository<Actor, Long> {
    @Query(value = "SELECT * FROM actor WHERE email='nicoletaungur@gmail.com'", nativeQuery = true)
    Actor findByEmail(String email);
}