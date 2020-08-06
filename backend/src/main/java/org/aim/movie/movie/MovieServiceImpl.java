package org.aim.movie.movie;

import java.util.ArrayList;
import java.util.List;

import org.aim.movie.rest.ApiResponse;
import org.aim.movie.rest.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse<Movie>> save(Movie movie) {
        System.out.println("MovieServiceImpl.createMovie() movie=" + movie); 

        ApiResponse<Movie> apiResponse = new ApiResponse<Movie>();
        List<ErrorMessage> errors = new ArrayList<>();

        if (movie.getMovieTitle() == null) {
            ErrorMessage errorMessage = new ErrorMessage("MISSING_TITLE", "Movie Title is Missing");
            errors.add(errorMessage);
        }

        if (movie.getDirector() == null || movie.getDirector().getId() == null) {
            System.out.println("MovieServiceImpl.createMovie() movie.getDirector()=" + movie.getDirector()); 
            ErrorMessage errorMessage = new ErrorMessage("MISSING_DIRECTOR", "Director is Missing");
            errors.add(errorMessage);
        }

        if (movie.getGenre() == null || movie.getGenre().getId() == null) {
            ErrorMessage errorMessage = new ErrorMessage("MISSING_GENRE", "Genre is Missing");
            errors.add(errorMessage);
        }

        if (movie.getRating() == null || movie.getRating().getId() == null) {
            ErrorMessage errorMessage = new ErrorMessage("MISSING_RATING", "Rating is Missing");
            errors.add(errorMessage);
        }

        if (errors.size() > 0) {
            System.out.println("MovieServiceImpl.createMovie() error saving movie"); 
            apiResponse.setErrors(errors);
            return ResponseEntity.badRequest().body(apiResponse);
        }

        System.out.println("MovieServiceImpl.createMovie() saving movie"); 
        Movie savedMovie = movieRepository.save(movie);
        apiResponse.setResponse(savedMovie);
        return ResponseEntity.status(201).body(apiResponse);
    }

}