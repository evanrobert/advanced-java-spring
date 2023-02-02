package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {
    @Autowired
    carRepo carRepo;
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class);}


    @Override
    public void run(String... args) throws Exception {
        car nissan = car.builder().brand("nissan").name("370z").mileage(22000).style("coupe").build();
        car ford = car.builder().brand("Ford").name("f150").mileage(80000).style("truck").build();
        car dodge = car.builder().brand("Dodge").name("charger").mileage(10).style("sedan").build();
        car honda = car.builder().brand("honda").name("civic").mileage(180000).style("sedan").build();

        System.out.println("*------------*");
        List<car> cars1 = carRepo.findByName("dodge");
        cars1.forEach(System.out::println);

        System.out.println("*------------*");
        List<car> cars2 = carRepo.queryByName("civic");
        cars1.forEach(System.out::println);
        System.out.println("*-----------*");
        List<car> cars = carRepo.searchByBrand("Dodge");
        cars.forEach(System.out::println);



    }
}
