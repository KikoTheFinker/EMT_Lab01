package mk.ukim.finki.lab1_emt_213064.web;

import mk.ukim.finki.lab1_emt_213064.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String showAllCountries(Model model)
    {
        model.addAttribute("countries", this.countryService.findAll());
        return "countries";
    }

    @GetMapping("/add/country")
    public String addNewCountry()
    {
        return "addNewCountry";
    }

    @PostMapping("/save/country")
    public String saveCountry(@RequestParam String name,
                              @RequestParam String continent)
    {
        this.countryService.addNew(name,continent);
        return "redirect:/countries";
    }

    @PostMapping("/delete/{id}")
    public String deleteCountry(@PathVariable Long id)
    {
        this.countryService.delete(id);
        return "redirect:/countries";
    }
}
