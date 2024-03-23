package mk.ukim.finki.lab1_emt_213064.service.impl;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab1_emt_213064.repository.CountryRepository;
import mk.ukim.finki.lab1_emt_213064.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> addNew(String name, String continent) {
        Country country = new Country(name, continent);
        return Optional.of(this.countryRepository.save(country));

    }

    @Override
    public void delete(Long id) {
        this.countryRepository.deleteById(id);
    }
    @Override
    public Country findById(Long id) throws CountryNotFoundException {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }
}
