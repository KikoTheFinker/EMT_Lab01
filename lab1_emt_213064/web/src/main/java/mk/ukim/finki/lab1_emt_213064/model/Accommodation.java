package mk.ukim.finki.lab1_emt_213064.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab1_emt_213064.model.enumerations.Category;




@Data
@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Integer numRooms;
    @ManyToOne
    private Host host;
    private boolean booked;

    public Accommodation(String name, Category category, Integer numRooms, Host host) {
        this.name = name;
        this.category = category;
        this.numRooms = numRooms;
        this.host = host;
        this.booked = false;
    }

    public Accommodation() {}
}
