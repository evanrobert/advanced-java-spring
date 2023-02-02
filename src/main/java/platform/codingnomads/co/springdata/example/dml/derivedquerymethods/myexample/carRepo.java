package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface carRepo extends JpaRepository<car, Long> {
    List<car> findByName(String name);
   List<car> queryByName(String name);
   List<car> readByName(String names);
   List<car> searchByBrand(String brand);
   List<car> findByNameIs(String name);
   List<car> findByBrandIsNot(String brand);
    List<car> findTop2HighestMileage();
    List<car> findTop2LowestMileage();
   List<car> findDistinctCarNames(String name);
  List<car> findByDistinctMileage(double mil);


}
