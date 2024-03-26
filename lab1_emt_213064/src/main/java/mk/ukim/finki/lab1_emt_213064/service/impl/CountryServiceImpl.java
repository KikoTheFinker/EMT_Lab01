package mk.ukim.finki.lab1_emt_213064.service.impl;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import mk.ukim.finki.lab1_emt_213064.model.dto.CountryDto;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab1_emt_213064.repository.CountryRepository;
import mk.ukim.finki.lab1_emt_213064.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        return Optional.of(this.countryRepository.save
                (new Country(countryDto.getName(), countryDto.getContinent())));
    }


    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto)  {
        Country country = this.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void delete(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return this.countryRepository.findAll(pageable);
    }


}
