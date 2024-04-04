package mk.ukim.finki.lab1_emt_213064.service;

import mk.ukim.finki.lab1_emt_213064.model.Accommodation;
import mk.ukim.finki.lab1_emt_213064.model.dto.AccommodationDto;
import mk.ukim.finki.lab1_emt_213064.model.enumerations.Category;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.AccommodationNotFoundException;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.HostNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> save(AccommodationDto accommodationDto);
    void delete(Long id);
    Optional<Accommodation> edit (Long id,AccommodationDto accommodationDto);
    Optional<Accommodation> markAsBooked(Long id);


}
