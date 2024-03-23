package mk.ukim.finki.lab1_emt_213064.repository;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
