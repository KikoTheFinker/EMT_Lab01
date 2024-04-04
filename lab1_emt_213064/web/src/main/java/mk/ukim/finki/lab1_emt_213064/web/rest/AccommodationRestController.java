package mk.ukim.finki.lab1_emt_213064.web.rest;

import mk.ukim.finki.lab1_emt_213064.model.Accommodation;
import mk.ukim.finki.lab1_emt_213064.model.dto.AccommodationDto;
import mk.ukim.finki.lab1_emt_213064.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/accom")
public class AccommodationRestController {
    private final AccommodationService accommodationService;

    public AccommodationRestController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }
    @GetMapping
    public List<Accommodation> findAll()
    {
        return this.accommodationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id)
    {
        return this.accommodationService.findById(id)
                .map(accom -> ResponseEntity.ok().body(accom))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //localhost:8082/api/host?id=3&name=host1 - request param
    //localhost:8082/api/host/3/host1 - path variable
    @PostMapping("/save")
    public ResponseEntity<Accommodation> save(@RequestBody AccommodationDto accDto)
    {
        return this.accommodationService.save(accDto)
                .map(acc -> ResponseEntity.ok().body(acc))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> edit(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto)
    {
        return this.accommodationService.edit(id, accommodationDto)
                .map(acc -> ResponseEntity.ok().body(acc))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id)
    {
        this.accommodationService.delete(id);
        if(this.accommodationService.findById(id).isEmpty())
        {
            return ResponseEntity.ok().build();
        } return ResponseEntity.badRequest().build();
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Accommodation> markAsBooked(@PathVariable Long id)
    {
        return this.accommodationService.markAsBooked(id)
                .map(acc -> ResponseEntity.ok().body(acc))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
