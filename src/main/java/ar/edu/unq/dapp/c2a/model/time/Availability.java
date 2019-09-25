package ar.edu.unq.dapp.c2a.model.time;

import org.springframework.jmx.access.InvalidInvocationException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Calendar;

@Entity
public class Availability{

    private final Calendar expirationDate;
    private final Calendar startingDate;
    @Id
    @GeneratedValue
    private Long id;

    public Availability(Calendar startingDate, Calendar expirationDate) {
        if (startingDate == null || expirationDate == null) {
            //TODO: Change exception type to custom exception
            throw new InvalidInvocationException("Debe poner una fecha de inicio y una fecha de fin");
        }

        this.startingDate = startingDate;
        this.expirationDate = expirationDate;
    }

    
    public Long getId() {
        return this.id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public boolean isAvailableAt(Calendar date) {
        return date.equals(startingDate) || (
                date.before(expirationDate) && date.after(startingDate)
        );

    }
}
