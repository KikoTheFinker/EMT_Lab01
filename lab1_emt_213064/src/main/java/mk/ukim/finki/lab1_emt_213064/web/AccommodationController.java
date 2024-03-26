package mk.ukim.finki.lab1_emt_213064.web;
/*
import mk.ukim.finki.lab1_emt_213064.model.Accommodation;
import mk.ukim.finki.lab1_emt_213064.model.enumerations.Category;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.AccommodationNotFoundException;
import mk.ukim.finki.lab1_emt_213064.model.exceptions.HostNotFoundException;
import mk.ukim.finki.lab1_emt_213064.service.AccommodationService;
import mk.ukim.finki.lab1_emt_213064.service.HostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationController(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @GetMapping("/accommodations")
    public String showAll(Model model)
    {
        model.addAttribute("accom", this.accommodationService.findAll());
        return "accommodations";
    }

    @GetMapping("/add/accom")
    public String addNewAccom(Model model)
    {
        model.addAttribute("hosts", this.hostService.findAll());
        model.addAttribute("categories", Category.values());
        return "addNewAccom";
    }

    @PostMapping("/save/accom")
    public String saveAccom(@RequestParam String name,
                            @RequestParam Category category,
                            @RequestParam Integer numRooms,
                            @RequestParam Long host)
    {
        try {
            this.accommodationService.save(name, category, numRooms, host);
        } catch (HostNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/accommodations";
    }

    @PostMapping("/delete/accom/{id}")
    public String deleteAccom(@PathVariable Long id){
        this.accommodationService.delete(id);
        return "redirect:/accommodations";
    }

    @GetMapping("/edit/{id}")
    public String editAccom(@PathVariable Long id, Model model)
    {
        try {
            Accommodation accommodation = this.accommodationService.findById(id);
            model.addAttribute("hosts", this.hostService.findAll());
            model.addAttribute("categories", Category.values());
            model.addAttribute("accommodation", accommodation);
        } catch (AccommodationNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "addNewAccom";
    }

    @PostMapping("/save/accom/{id}")
    public String editedAccom(@RequestParam String name,
                              @RequestParam Category category,
                              @RequestParam Integer numRooms,
                              @RequestParam Long host,
                              @PathVariable Long id)
    {
        try {
            this.accommodationService.update(id, name, category, numRooms, host);
        } catch (AccommodationNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/accommodations";
    }

    @PostMapping("/book/accom/{id}")
    public String bookAccom(@PathVariable Long id)
    {
        this.accommodationService.markAsBooked(id);
        return "redirect:/accommodations";
    }

}
*/