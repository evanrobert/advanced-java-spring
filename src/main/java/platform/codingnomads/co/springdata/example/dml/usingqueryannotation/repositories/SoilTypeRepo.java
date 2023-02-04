package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.Plant;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.ArrayList;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {
    @Query("SELECT st FROM SoilType st WHERE dry = true")
    ArrayList<Plant> getDrySoil(Sort sort);
    @Query( "SELECT count(id) FROM SoilType")
    long findNumberOfPlants();
    @Query(value = "SELECT count(id) FROM plants", nativeQuery = true)
    long findIdOfPlants();
    @Query("SELECT dry FROM SoilType Where dry = True ")
    boolean findDry();
    @Query("SELECT p FROM Plant p WHERE id = ?1")
    Plant getPlantById(Long id, int a);

}
