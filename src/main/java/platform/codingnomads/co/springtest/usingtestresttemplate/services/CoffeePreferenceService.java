package platform.codingnomads.co.springtest.usingtestresttemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;
import platform.codingnomads.co.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;

import java.util.Optional;

@Service
public class CoffeePreferenceService {

    @Autowired
    private CoffeePreferenceRepo repo;

    public CoffeePreference insertNewCoffeePreference(CoffeePreference coffeePreference) {
        return repo.save(coffeePreference);
    }


    public Optional<CoffeePreference> getCoffeePreferenceById(Long id) {
        return repo.findById(id);
    }
}
