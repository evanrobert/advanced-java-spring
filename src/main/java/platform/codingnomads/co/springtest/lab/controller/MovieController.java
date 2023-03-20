package platform.codingnomads.co.springtest.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("movies/rating")
    public List<Movie> getMinRating(double rating) {
        List<Movie> movies = movieService.getRatings(rating);
        List<Movie> filteredMovies = movies.stream()
                .filter(movie -> movie.getRating() >= rating)
                .collect(Collectors.toList());
        return filteredMovies;
    }
}






















