package org.aim.movie.movie;

import org.springframework.data.repository.CrudRepository;

import org.aim.movie.movie.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}