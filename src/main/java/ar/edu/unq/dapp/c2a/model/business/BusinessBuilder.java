package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.Builder;

public class BusinessBuilder implements Builder<Business> {
    
    public Business build() {
        return new Business();
    }
}
