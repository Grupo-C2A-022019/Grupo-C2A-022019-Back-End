package ar.edu.unq.dapp.c2a.model.time;

import java.util.Calendar;

public interface Availability {
    boolean isAvailableAt(Calendar date);
}
