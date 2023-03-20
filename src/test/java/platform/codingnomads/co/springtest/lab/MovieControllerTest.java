package platform.codingnomads.co.springtest.lab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import platform.codingnomads.co.springtest.lab.controller.MovieController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    MovieService movieService;
    @Autowired
    MovieController movieController;
    @MockBean
    MovieRepository movieRepository;


    @Test
    public void testGetAllMoviesSuccess() throws Exception {

        List<Movie> expectedMovies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
        );

        Mockito.when(movieRepository.findAll()).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getAllMovies();

        Assertions.assertEquals(expectedMovies.size(), actualMovies.size());
        Assertions.assertTrue(expectedMovies.containsAll(actualMovies));
    }

    @Test
    public void testGetAllMoviesFailure() {

        List<Movie> expectedMovies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happynessss").rating(8.0).build(),
                Movie.builder().name("The GodFather").rating(9.5).build());

        ;
        Mockito.when(movieRepository.findAll()).thenReturn(expectedMovies);
        List<Movie> actualMovies = movieService.getAllMovies();
        Assertions.assertEquals(expectedMovies.size(), actualMovies.size());
        Assertions.assertTrue(expectedMovies.containsAll(actualMovies));


    }


    @Test
    public void testGetAllMoviesSuccessMockService() {
        List<Movie> expectedMovies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()

        );
        Mockito.when(movieRepository.findAll()).thenReturn(expectedMovies);
        List<Movie> actualmovies = movieService.getAllMovies();
        Assertions.assertEquals(expectedMovies.size(), actualmovies.size());
        Assertions.assertTrue(expectedMovies.containsAll(actualmovies));


    }

    @Test
    public void testGetAllMoviesSuccess2() throws Exception {
        List<Movie> expectedMovies = Arrays.asList(
                Movie.builder().name("The Shawshank Redemption").rating(9.3).build(),
                Movie.builder().name("The Pursuit of Happyness").rating(8.0).build()
        );

        Mockito.when(movieRepository.findAll()).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getAllMovies();

        Assertions.assertAll("Movies should match",
                () -> Assertions.assertEquals(expectedMovies.size(), actualMovies.size()),
                () -> expectedMovies.stream()
                        .forEach(expectedMovie -> Assertions.assertTrue(actualMovies.contains(expectedMovie)))
        );
    }

    @Test
    public void testGetMinRating() {
        List<Movie> expectedMovies = new ArrayList<>();
        double rating = 4.5;
        List<Movie> actualMovies = movieController.getMinRating(rating);
        assertEquals(expectedMovies, actualMovies);
    }





}








//
//        Task 5: Implement success and failure testing for this new endpoint.
//
//        Task 6: Create a new test class for MovieService. As a short-cut, try right-clicking the class declaration in IntelliJ
//        and click "Generate..", then click "Test". You can select the destination package and methods to include. When using this,
//        it is recommended you rename the generated test methods to be more verbose (more like the example method names).
//
//
//
//        Task 7: Add the required Spring testing annotations,
//        and implement complete testing methods to ensure functionality of your MovieService class.



