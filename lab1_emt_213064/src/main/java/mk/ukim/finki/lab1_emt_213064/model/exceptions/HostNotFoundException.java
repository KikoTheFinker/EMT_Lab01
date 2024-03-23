package mk.ukim.finki.lab1_emt_213064.model.exceptions;

public class HostNotFoundException extends Exception{
    public HostNotFoundException(Long id) {
        super(String.format("Host with id %d was not found", id));
    }
}
