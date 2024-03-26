package mk.ukim.finki.lab1_emt_213064.service.impl;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import mk.ukim.finki.lab1_emt_213064.model.Host;
import mk.ukim.finki.lab1_emt_213064.model.dto.HostDto;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.HostNotFoundException;
import mk.ukim.finki.lab1_emt_213064.repository.CountryRepository;
import mk.ukim.finki.lab1_emt_213064.repository.HostRepository;
import mk.ukim.finki.lab1_emt_213064.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return this.hostRepository.findById(id);
    }

    @Override
    public Optional<Host> save(HostDto hostDto) {
        Country country = this.countryRepository.findById(hostDto.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException(hostDto.getCountryId()));
        return Optional.of(this.hostRepository.save(new Host(hostDto.getName(), hostDto.getSurname(),
                country)));
    }

    @Override
    public Optional<Host> edit(Long id, HostDto hostDto) {
        Host host = this.hostRepository.findById(id)
                .orElseThrow(() -> new HostNotFoundException(id));
        Country country = this.countryRepository.findById(hostDto.getCountryId())
                        .orElseThrow(() -> new CountryNotFoundException(hostDto.getCountryId()));
        host.setName(hostDto.getName());
        host.setSurname(hostDto.getSurname());
        host.setCountry(country);
        return Optional.of(this.hostRepository.save(host));
    }

    @Override
    public void delete(Long hostId) {
        this.hostRepository.deleteById(hostId);
    }
}
