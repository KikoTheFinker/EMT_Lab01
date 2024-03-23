package mk.ukim.finki.lab1_emt_213064.service;

import mk.ukim.finki.lab1_emt_213064.model.Accommodation;
import mk.ukim.finki.lab1_emt_213064.model.enumerations.Category;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.AccommodationNotFoundException;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.HostNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> save(String name, Category category, Integer numRooms, Long hostId) throws HostNotFoundException;
    void delete(Long id);
    Optional<Accommodation> update(Long id,String name, Category category, Integer numRooms, Long hostId) throws AccommodationNotFoundException;
    void markAsBooked(Long id);

    Accommodation findById(Long id) throws AccommodationNotFoundException;
}
