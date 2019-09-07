package ar.edu.unq.dapp.c2a.model.time;

import org.springframework.jmx.access.InvalidInvocationException;

import java.util.Calendar;

public class TimeRangeAvailability implements Availability {
    private final Calendar expirationDate;
    private final Calendar startingDate;

    public TimeRangeAvailability(Calendar startingDate, Calendar expirationDate) {
        if(startingDate == null || expirationDate == null) {
            //TODO: Change exception type to custom exception
            throw new InvalidInvocationException("Debe poner una fecha de inicio y una fecha de fin");
        }

        this.startingDate = startingDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isAvailableAt(Calendar date) {
        return date.equals(startingDate) || (
                date.before(expirationDate) && date.after(startingDate)
        );

    }
}
