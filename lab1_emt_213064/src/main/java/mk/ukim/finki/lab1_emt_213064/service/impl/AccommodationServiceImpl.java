package mk.ukim.finki.lab1_emt_213064.service.impl;

import mk.ukim.finki.lab1_emt_213064.model.Accommodation;
import mk.ukim.finki.lab1_emt_213064.model.Host;
import mk.ukim.finki.lab1_emt_213064.model.dto.AccommodationDto;
import mk.ukim.finki.lab1_emt_213064.model.enumerations.Category;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.AccommodationNotFoundException;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.HostNotFoundException;
import mk.ukim.finki.lab1_emt_213064.repository.AccommodationRepository;
import mk.ukim.finki.lab1_emt_213064.repository.HostRepository;
import mk.ukim.finki.lab1_emt_213064.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return this.accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> save(AccommodationDto accommodationDto) {
        Host host = this.hostRepository.findById(accommodationDto.getHostId())
                .orElseThrow(() -> new HostNotFoundException(accommodationDto.getHostId()));

        return Optional.of(this.accommodationRepository
                .save(new Accommodation(accommodationDto.getName(),
                        Category.valueOf(accommodationDto.getCategory()),
                        accommodationDto.getNumRooms(), host)));
    }

    @Override
    public void delete(Long id) {
        this.accommodationRepository.deleteById(id);
    }

    @Override
    public Optional<Accommodation> edit(Long id, AccommodationDto accommodationDto) {
        Accommodation accommodation = this.accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
        Host host = this.hostRepository.findById(accommodationDto.getHostId())
                .orElseThrow(() -> new HostNotFoundException(accommodationDto.getHostId()));
        accommodation.setName(accommodationDto.getName());
        accommodation.setCategory(Category.valueOf(accommodationDto.getCategory()));
        accommodation.setNumRooms(accommodationDto.getNumRooms());
        accommodation.setHost(host);
        return Optional.of(this.accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> markAsBooked(Long id) {
        Accommodation accommodation = this.accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
        accommodation.setBooked(true);
        return Optional.of(this.accommodationRepository.save(accommodation));
    }
}



