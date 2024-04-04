package mk.ukim.finki.lab1_emt_213064.web.rest;

import mk.ukim.finki.lab1_emt_213064.model.Host;
import mk.ukim.finki.lab1_emt_213064.model.dto.HostDto;
import mk.ukim.finki.lab1_emt_213064.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/hosts")
public class HostRestController {

    private final HostService hostService;

    public HostRestController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping
    public List<Host> findAll()
    {
        return this.hostService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable Long id)
    {
        return this.hostService.findById(id)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/save")
    public ResponseEntity<Host> save(@RequestBody HostDto hostDto)
    {
        return this.hostService.save(hostDto)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Host> edit(@PathVariable Long id, @RequestBody HostDto hostDto)
    {
        return this.hostService.edit(id, hostDto)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id)
    {
        this.hostService.delete(id);
        if(this.hostService.findById(id).isEmpty())
        {
            return ResponseEntity.ok().build();
        } return ResponseEntity.badRequest().build();
    }

}
