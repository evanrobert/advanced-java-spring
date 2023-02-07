package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(FoodMapper foodMapper) {
        return (args) -> {
            //notice the setter names have changed to match Java naming conventions

            Food food = new Food();
            food.setType("Italian");
            food.setCost(15);
           food.setServingsize(3.0);
            food.setName("Pizza");
            foodMapper.insertNewFood(food);
            Food food1 = new Food();
            food1.setType("mexican");
            food1.setCost(7);
            food1.setServingsize(1);
            food1.setName("Tacos");
            foodMapper.insertNewFood(food1);

            foodMapper.uodate(food1);;

        };
    }
}
