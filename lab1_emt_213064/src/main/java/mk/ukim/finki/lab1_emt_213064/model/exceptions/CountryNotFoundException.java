package mk.ukim.finki.lab1_emt_213064.model.exceptions;

public class CountryNotFoundException extends Exception{
    public CountryNotFoundException(Long id) {
        super(String.format("Country with id %d was not found", id));
    }
}
