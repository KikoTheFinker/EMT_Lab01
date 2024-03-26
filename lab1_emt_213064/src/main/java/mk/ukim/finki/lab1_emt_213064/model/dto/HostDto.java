package mk.ukim.finki.lab1_emt_213064.model.dto;

import lombok.Data;

@Data
public class HostDto {
    private String name;
    private String surname;
    private Long countryId;

    public HostDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }
}
