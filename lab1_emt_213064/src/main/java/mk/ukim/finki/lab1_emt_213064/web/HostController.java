package mk.ukim.finki.lab1_emt_213064.web;
/*
import mk.ukim.finki.lab1_emt_213064.service.CountryService;
import mk.ukim.finki.lab1_emt_213064.service.HostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HostController {
    private final HostService hostService;
    private final CountryService countryService;

    public HostController(HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }

    @GetMapping("/hosts")
    public String getAllHosts(Model model)
    {
        model.addAttribute("hosts", this.hostService.findAll());
        return "hosts";
    }

    @GetMapping("/add/host")
    public String addNewHost(Model model)
    {
        model.addAttribute("countries", this.countryService.findAll());
        return "addNewHost";
    }

    @PostMapping("/save/host")
    public String saveHost(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam Long country,Model model) throws Exception {
        if (country == null) {
            model.addAttribute("errorMessage", "Country cannot be null.");
            return "addNewHost";
        }
        else {
            this.hostService.save(name, surname, country);
        }
        return "redirect:/hosts";
    }

    @PostMapping("/delete/host/{id}")
    public String deleteHost(@PathVariable Long id)
    {
        this.hostService.delete(id);
        return "redirect:/hosts";
    }

}
*/