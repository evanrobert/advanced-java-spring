package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;

@SpringBootApplication
public class PostForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForObjectMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            ApiTemplate apiTemplate = ApiTemplate.builder().first_name("Bill").last_name("Nye").email("BillNYE12345@gmail.com").build();
            ApiTemplate apiTemplate2 = ApiTemplate.builder().first_name("Nike").last_name("Adidas").email("Nikes@gmail.com").build();

            ResponseObject taskReturnedByServerAfterPost = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/users", apiTemplate2, ResponseObject.class);
            ResponseObject responseObject = restTemplate.postForObject("http://demo.codingnomads.co:8080/tasks_api/users", apiTemplate, ResponseObject.class);
            if (taskReturnedByServerAfterPost != null) {
                System.out.println(taskReturnedByServerAfterPost.toString());
                if(responseObject != null){
                    System.out.println(responseObject.toString());
                }
            }
        };
    }
}
