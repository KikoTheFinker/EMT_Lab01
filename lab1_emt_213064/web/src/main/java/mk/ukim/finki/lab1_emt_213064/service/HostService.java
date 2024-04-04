package mk.ukim.finki.lab1_emt_213064.service;

import mk.ukim.finki.lab1_emt_213064.model.Host;
import mk.ukim.finki.lab1_emt_213064.model.dto.HostDto;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();

    Optional<Host> findById(Long id);
    Optional<Host> save(HostDto hostDto);

    Optional<Host> edit(Long id, HostDto hostDto);

    void delete(Long hostId);

}
