package mk.ukim.finki.lab1_emt_213064.service.impl;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import mk.ukim.finki.lab1_emt_213064.model.Host;
import mk.ukim.finki.lab1_emt_213064.repository.HostRepository;
import mk.ukim.finki.lab1_emt_213064.service.CountryService;
import mk.ukim.finki.lab1_emt_213064.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> save(String name, String surname, Long countryId) {
        Country country = new Country();
        try {
            country = this.countryService.findById(countryId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Host host = new Host(name, surname, country);
        return Optional.of(this.hostRepository.save(host));
    }

    @Override
    public void delete(Long hostId) {
        this.hostRepository.deleteById(hostId);
    }

    @Override
    public Optional<Host> findById(Long id) {
        return this.hostRepository.findById(id);
    }
}
