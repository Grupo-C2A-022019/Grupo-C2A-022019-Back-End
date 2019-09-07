package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.Builder;

import javax.money.MonetaryAmount;

public class    PricingSchemaBuilder implements Builder<PricingSchema> {
    private MonetaryAmount fullPrice;

    @Override
    public PricingSchema build() {
        return new PlainFeePricingSchema(fullPrice);
    }

    public PricingSchemaBuilder withFullPrice(MonetaryAmount fullPrice) {
        this.fullPrice = fullPrice;
        return this;
    }
}
