package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.Plant;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.ArrayList;

@Service
public class SoilService {
    @Autowired
    SoilTypeRepo soilTypeRepo;
    public void create(){

        SoilType soilType1 = SoilType.builder().name("EVAN").ph(22).dry(false).build();
        SoilType soilType2 = SoilType.builder().name("Giselle").ph(23).dry(false).build();
        SoilType soilType3 = SoilType.builder().name("ELIJAH").ph(24).dry(false).build();
        soilTypeRepo.save(soilType1);
        soilTypeRepo.save(soilType2);
        soilTypeRepo.save(soilType3);

    }


    public void getStuffs() {
        System.out.println("---------");
        ArrayList<Plant> soilTypes = soilTypeRepo.getDrySoil(Sort.by(Sort.Order.desc("id")));
        for (Plant s : soilTypes) {
            System.out.println(s.toString());
        }
    }

    public void find() {
        System.out.println("---------");
        long soils = soilTypeRepo.findNumberOfPlants();
        System.out.println(soils);
    }

//    public void findID() {
//        System.out.println("--------");
//long x =   soilTypeRepo.findIdOfPlants();
//        System.out.println(x);




        public void findDry(){
            System.out.println("------------");
            boolean a = soilTypeRepo.findDry();
            System.out.println(a);
        }
        public void last(){
       Plant q =  soilTypeRepo.getPlantById(1l,2);
            System.out.println(q);
        }


        }




