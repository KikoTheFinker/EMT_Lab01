package mk.ukim.finki.lab1_emt_213064.model.dto;

import lombok.Data;

@Data
public class AccommodationDto {
    private String name;
    private String category;
    private Integer numRooms;
    private Long hostId;
    private boolean hasBeenBooked;

    public AccommodationDto(String name, String category, Integer numRooms, Long hostId) {
        this.name = name;
        this.category = category;
        this.numRooms = numRooms;
        this.hostId = hostId;
        this.hasBeenBooked = false;
    }
}
