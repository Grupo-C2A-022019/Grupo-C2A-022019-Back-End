package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;


@Entity
public class PlainFeePricingSchema extends PricingSchema {
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount price;

    public PlainFeePricingSchema() {
    }

    public PlainFeePricingSchema(MonetaryAmount price) {
        this.price = price;
    }

    public MonetaryAmount getPrice(Order order) {
        return price.multiply(order.getAmount());
    }

    void setPrice(MonetaryAmount price) {
        this.price = price;
    }

    public MonetaryAmount getListPrice() {
        return price;
    }

    @Override
    public MonetaryAmount getDiscountPrice(Menu menu) {
        return null;
    }
}
