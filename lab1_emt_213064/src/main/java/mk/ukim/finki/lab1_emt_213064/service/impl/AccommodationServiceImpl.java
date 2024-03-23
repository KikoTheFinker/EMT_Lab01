package mk.ukim.finki.lab1_emt_213064.service.impl;

import mk.ukim.finki.lab1_emt_213064.model.Accommodation;
import mk.ukim.finki.lab1_emt_213064.model.Host;
import mk.ukim.finki.lab1_emt_213064.model.enumerations.Category;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.AccommodationNotFoundException;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.HostNotFoundException;
import mk.ukim.finki.lab1_emt_213064.repository.AccommodationRepository;
import mk.ukim.finki.lab1_emt_213064.service.AccommodationService;
import mk.ukim.finki.lab1_emt_213064.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> save(String name, Category category, Integer numRooms, Long hostId) throws HostNotFoundException {
        Host host = this.hostService.findById(hostId)
                .orElseThrow(() -> new HostNotFoundException(hostId));
        Accommodation accommodation = new Accommodation(name, category, numRooms, host);
        return Optional.of(this.accommodationRepository.save(accommodation));
    }

    @Override
    public void delete(Long id) {
        this.accommodationRepository.deleteById(id);
    }

    @Override
    public Optional<Accommodation> update(Long id, String name, Category category, Integer numRooms, Long hostId)  {
        Accommodation accommodation = new Accommodation();
        try {
            accommodation = this.findById(id);
            accommodation.setName(name);
            accommodation.setCategory(category);
            accommodation.setNumRooms(numRooms);
            Optional<Host> host = this.hostService.findById(hostId);
            if(host.isPresent()) accommodation.setHost(host.get());
            this.accommodationRepository.save(accommodation);
        } catch (AccommodationNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(accommodation);
    }

    @Override
    public void markAsBooked(Long id) {
        try {
            Accommodation accommodation = this.findById(id);
            accommodation.setBooked(true);
            this.accommodationRepository.save(accommodation);
        } catch (AccommodationNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Accommodation findById(Long id) throws AccommodationNotFoundException {
        return this.accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
    }
}
