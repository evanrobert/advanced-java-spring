package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Connection;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {
//    List<Route> findByOrigin(String code);
//    List<Route> findByDestination(String code);
    List<Route> findAllByCodeContaining(String code);
}
