package platform.codingnomads.co.springweb.resttemplate.POST.postForLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;

import java.net.URI;
import java.util.Objects;

@SpringBootApplication
public class PostForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForLocationMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Task newTask = Task.builder()
                    .name("learn how to use postForLocation()")
                    .description("get comfortable using the RestTemplate postForLocation() method")
                    //be sure to use a valid user id
                    .userId(380)
                    .completed(false)
                    .build();
            Task task2 = Task.builder().name("Learning post").description("working through spring web").userId(381).completed(false).build();

            //use postForLocation() to get the URL for the new resource
            URI returnedLocation = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);
            URI uri = restTemplate.postForLocation("http://demo.codingnomads.co:8080/tasks_api/tasks", task2, ResponseObject.class);

            System.out.println(Objects.requireNonNull(returnedLocation));
            System.out.println(Objects.requireNonNull(uri));



        };
    }
}
