package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;

public class BulkSizeDiscountPricingSchema extends PlainFeePricingSchema {
    private final Integer bulkSize;
    private final MonetaryAmount discountedPrice;

    public BulkSizeDiscountPricingSchema(MonetaryAmount fullPrice, Integer bulkSize, MonetaryAmount discountedPrice) {
        super(fullPrice);
        this.bulkSize = bulkSize;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public MonetaryAmount getPrice(Order order) {
        if(order.getMenu().getAmountOfPendigs() >= bulkSize){
            return discountedPrice.multiply(order.getAmount());
        }

        return super.getPrice(order);
    }
}
