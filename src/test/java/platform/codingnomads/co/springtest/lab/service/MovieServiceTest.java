package platform.codingnomads.co.springtest.lab.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MovieServiceTest {
    @Autowired
    MovieService movieService;
    @Autowired
    MovieRepository movieRepository;


    @Test
    public void testGetAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
            assertNotNull(movies);
            assertEquals(2, movies.size());
            assertEquals("The Shawshank Redemption", movies.get(0).getName());
            assertEquals("The Pursuit of Happyness", movies.get(1).getName());

        }
    @Test
    public void testGetRatings() {

        MovieRepository movieRepositoryMock = mock(MovieRepository.class);
        List<Movie> allMovies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()

        );
        when(movieRepositoryMock.findAll()).thenReturn(allMovies);

        MovieService movieService = new MovieServiceImpl();


        List<Movie> ratedMovies = movieService.getRatings(7.0);


        assertEquals(2, ratedMovies.size());
        assertEquals("The Shawshank Redemption", ratedMovies.get(0).getName());
        assertEquals("The Pursuit of Happyness", ratedMovies.get(1).getName());
    }

}





