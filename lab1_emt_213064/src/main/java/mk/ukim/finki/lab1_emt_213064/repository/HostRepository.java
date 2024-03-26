package mk.ukim.finki.lab1_emt_213064.repository;

import mk.ukim.finki.lab1_emt_213064.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
