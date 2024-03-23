package mk.ukim.finki.lab1_emt_213064.model.exceptions;

public class AccommodationNotFoundException extends Exception{
    public AccommodationNotFoundException(Long id) {
        super(String.format("Accommodation with id %d was not found", id));
    }
}
