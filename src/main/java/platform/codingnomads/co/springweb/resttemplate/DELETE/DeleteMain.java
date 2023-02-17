package platform.codingnomads.co.springweb.resttemplate.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.Task;

@SpringBootApplication
public class DeleteMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeleteMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            Task newTask = Task.builder()
                    .name("should be deleted")
                    .description("used in a delete RestTemplate example. If you see this something went wrong. Oops")
                    //be sure to enter a valid user id
                    .userId(381)
                    .completed(false)
                    .build();
            Task task2 = Task.builder().name("should be deleted")
                    .description("used in a delete RestTemplate example. If you see this something went wrong. Oops")
                    //be sure to enter a valid user id
                    .userId(398)
                    .completed(false)
                    .build();

            //POST new task to server
            ResponseObject responseObject = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/", newTask, ResponseObject.class);
            ResponseObject responseObject2 = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/", task2, ResponseObject.class);
            //confirm data was returned & avoid NullPointerExceptions
            if (responseObject == null || responseObject2 == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null || responseObject2.getData() == null) {
                throw new Exception("The server encountered this error while creating the task:" + responseObject.getError().getMessage());
            } else {
                newTask = responseObject.getData();
                task2 = responseObject2.getData();
            }

            System.out.println("The task was successfully created");
            System.out.println(newTask);
            System.out.println("task 2 was created ");
            System.out.println(task2);

            //delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId());
            System.out.println("The task was also successfully deleted");

            //try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId(), ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }


            //try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + task2.getId(), ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            //delete using exchange()
            HttpEntity<Task> httpEntity = new HttpEntity<>(newTask);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/tasks/"
                        + newTask.getId(), HttpMethod.DELETE, httpEntity, ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
