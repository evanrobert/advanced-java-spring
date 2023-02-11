package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Connection;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.ConnectionRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;
    private  final ConnectionRepository connectionRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (areaRepository.findAll().size() == 0) {

            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build(),
                            Area.builder().code("A").build(),
                            Area.builder().code("B").build(),
                            Area.builder().code("C").build(),
                            Area.builder().code("D").build(),
                            Area.builder().code("E").build(),
                            Area.builder().code("F").build(),
                            Area.builder().code("I").build(),
                            Area.builder().code("J").build()

                    )
            );


        }
        if(routeRepository.findAll().size()==0){
            final  List<Route> routes = routeRepository.saveAll(
                    Arrays.asList(
                            Route.builder().origin(areaRepository.findByCode("G")).destination(areaRepository.findByCode("H")).build(),
                            Route.builder().origin(areaRepository.findByCode("Y")).destination(areaRepository.findByCode("Z")).build(),
                            Route.builder().origin(areaRepository.findByCode("A")).destination(areaRepository.findByCode("B")).build(),
                            Route.builder().origin(areaRepository.findByCode("C")).destination(areaRepository.findByCode("D")).build(),
                            Route.builder().origin(areaRepository.findByCode("E")).destination(areaRepository.findByCode("F")).build(),
                            Route.builder().origin(areaRepository.findByCode("I")).destination(areaRepository.findByCode("J")).build()



                    )
            );
        }
        if(connectionRepository.findAll().size()==0){
            Connection connection1 = new Connection("Gas-Station","Shell",areaRepository.findByCode("G"));
            connection1.addRoutes(routeRepository.findAllByCodeContaining("G"));
            Connection connection2 = new Connection("Gas-Station","76",areaRepository.findByCode("H"));
            connection2.addRoutes(routeRepository.findAllByCodeContaining("H"));
            Connection connection3 = new Connection("Rest-Stop","Rest",areaRepository.findByCode("Y"));
            connection3.addRoutes(routeRepository.findAllByCodeContaining("Y"));
            Connection connection4 = new Connection("Gas-Station","Drinks",areaRepository.findByCode("Z"));
            connection4.addRoutes(routeRepository.findAllByCodeContaining("Z"));
            Connection connection5 = new Connection("Food","KFC",areaRepository.findByCode("A"));
            connection5.addRoutes(routeRepository.findAllByCodeContaining("A"));
            Connection connection6 = new Connection("Food","KFC",areaRepository.findByCode("B"));
            connection6.addRoutes(routeRepository.findAllByCodeContaining("B"));
            final List<Connection> connections = connectionRepository.saveAll(
                    List.of(connection1,connection2,connection3,connection4,connection5,connection6)
            );
            System.out.println(areaRepository.findByCode("A"));
            System.out.println(areaRepository.findAll());








        }


    }
}
