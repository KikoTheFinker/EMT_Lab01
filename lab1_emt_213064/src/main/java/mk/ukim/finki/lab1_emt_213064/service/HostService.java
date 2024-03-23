package mk.ukim.finki.lab1_emt_213064.service;

import mk.ukim.finki.lab1_emt_213064.model.Host;
import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> save(String name, String surname, Long countryId) throws Exception;
    void delete(Long hostId);
    Optional<Host> findById(Long id);
}
