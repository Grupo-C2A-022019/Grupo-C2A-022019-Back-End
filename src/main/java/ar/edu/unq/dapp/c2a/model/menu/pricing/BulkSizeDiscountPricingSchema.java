package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;

@Entity
public class BulkSizeDiscountPricingSchema extends PlainFeePricingSchema {
    private Integer bulkSize;
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount discountedPrice;

    public BulkSizeDiscountPricingSchema() {
        super();
    }

    public BulkSizeDiscountPricingSchema(MonetaryAmount fullPrice, Integer bulkSize, MonetaryAmount discountedPrice) {
        super(fullPrice);
        this.bulkSize = bulkSize;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public MonetaryAmount getPrice(Order order) {
        if (order.getMenu().getAmountOfPendigs() >= bulkSize) {
            return discountedPrice.multiply(order.getAmount());
        }

        return super.getPrice(order);
    }

    void setBulkSize(int bulkSize) {
        this.bulkSize = bulkSize;
    }

    void setDiscountedPrice(MonetaryAmount price) {
        this.discountedPrice = price;
    }
}
