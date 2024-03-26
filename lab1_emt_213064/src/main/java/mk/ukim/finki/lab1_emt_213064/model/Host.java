package mk.ukim.finki.lab1_emt_213064.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String surname;

    @ManyToOne
    private Country country;

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
    public Host() {}
}
