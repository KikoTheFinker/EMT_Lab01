package mk.ukim.finki.lab1_emt_213064.web.rest;

import mk.ukim.finki.lab1_emt_213064.model.Country;
import mk.ukim.finki.lab1_emt_213064.model.dto.CountryDto;
import mk.ukim.finki.lab1_emt_213064.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    //todo Read
    @GetMapping
    public List<Country> findAll()
    {
        return this.countryService.findAll();
    }
    //ResponseEntity kje go sodrzhi samiot country object, no i response status code
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id)
    {
        return this.countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/paginated")
    public Page<Country> findAllPaginated(Pageable pageable)
    {
        return this.countryService.findAll(pageable);
    }

    //create
    @PostMapping("/save")
    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto)
    {
        return this.countryService.save(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    //update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> edit(@PathVariable Long id, @RequestBody CountryDto countryDto)
    {
        return this.countryService.edit(id, countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    //delete
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        this.countryService.delete(id);
    }
}
