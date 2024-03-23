package mk.ukim.finki.lab1_emt_213064.service;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> addNew(String name, String continent);
    void delete(Long id);

    Country findById(Long id) throws Exception;
}
