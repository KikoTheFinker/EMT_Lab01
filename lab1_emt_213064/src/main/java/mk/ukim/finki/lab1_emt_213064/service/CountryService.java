package mk.ukim.finki.lab1_emt_213064.service;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import mk.ukim.finki.lab1_emt_213064.model.dto.CountryDto;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.CountryNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);
    Optional<Country> save(CountryDto countryDto);
    Optional<Country> edit(Long id, CountryDto countryDto);
    void delete(Long id);
    Page<Country> findAll(Pageable pageable);


}
