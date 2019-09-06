package ar.edu.unq.dapp.c2a.model.time;

import java.util.Calendar;

public class TimeRangeAvailability implements Availability {
    private final Calendar expirationDate;
    private final Calendar startingDate;

    public TimeRangeAvailability(Calendar startingDate, Calendar expirationDate) {
        this.startingDate = startingDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isAvailableAt(Calendar date) {
        return date.before(expirationDate) && date.after(startingDate);
    }
}
