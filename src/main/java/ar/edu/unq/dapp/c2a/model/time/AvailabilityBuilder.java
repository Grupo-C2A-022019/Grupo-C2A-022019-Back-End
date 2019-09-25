package ar.edu.unq.dapp.c2a.model.time;

import ar.edu.unq.dapp.c2a.model.Builder;

import java.util.Calendar;

public class AvailabilityBuilder implements Builder<Availability> {
    private Calendar startingDate;
    private Calendar expirationDate;

    
    public Availability build() {
        return new Availability(startingDate, expirationDate);
    }

    public AvailabilityBuilder starting(Calendar at) {
        this.startingDate = at;
        return this;
    }

    public AvailabilityBuilder ending(Calendar expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }
}
