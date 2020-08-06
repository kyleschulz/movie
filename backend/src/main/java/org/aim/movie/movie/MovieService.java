package org.aim.movie.movie;

import org.aim.movie.rest.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface MovieService {
    public Iterable<Movie> getAllMovies();
    public ResponseEntity<ApiResponse<Movie>> save(Movie movie);
}