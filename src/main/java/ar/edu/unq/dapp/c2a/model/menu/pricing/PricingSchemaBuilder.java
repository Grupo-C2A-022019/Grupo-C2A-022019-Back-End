package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.Builder;

import javax.money.MonetaryAmount;

public class PricingSchemaBuilder implements Builder<PricingSchema> {
    private MonetaryAmount fullPrice;
    private Integer bulkSize;
    private MonetaryAmount discountedPrice;

    @Override
    public PricingSchema build() {
        if(bulkSize != null && discountedPrice != null) {
            return new BulkSizeDiscountPricingSchema(fullPrice, bulkSize, discountedPrice);
        }

        return new PlainFeePricingSchema(fullPrice);
    }

    public PricingSchemaBuilder withFullPrice(MonetaryAmount fullPrice) {
        this.fullPrice = fullPrice;
        return this;
    }

    public PricingSchemaBuilder withBulkDiscount(Integer bullkSize, MonetaryAmount discountedPrice) {
        this.bulkSize = bullkSize;
        this.discountedPrice = discountedPrice;
        return this;
    }
}
