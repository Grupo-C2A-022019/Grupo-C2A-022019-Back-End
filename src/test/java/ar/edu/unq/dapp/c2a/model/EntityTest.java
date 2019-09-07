package ar.edu.unq.dapp.c2a.model;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.geo.SimpleGeoLocation;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.io.Serializable;
import java.util.Calendar;

public abstract class EntityTest {

    protected Serializable aClientId() {
        return "clientId";
    }

    protected Serializable aMenuId() {
        return "menuId";
    }

    protected Business aBusiness() {
        return new BusinessBuilder().build();
    }

    protected Menu aMenu() {
        return new MenuBuilder()
                .withStartDate(anEarlierDate())
                .withExpirationDate(aLaterDate())
                .withBusiness(aBusiness())
                .withId(aMenuId())
                .withFullPrice(fullPrice())
                .build();
    }

    protected Client aClient() {
        return new ClientBuilder().withId(aClientId()).build();
    }

    protected Integer aAmount() {
        return 1;
    }

    protected DeliveryType aDeliveryType() {
        return DeliveryType.HOME_DELIVERY;
    }

    protected Calendar aTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY, 4, 15, 25, 30);
        return calendar;
    }

    protected Location aLocation() {
        return new SimpleGeoLocation(aLat(), aLng());
    }

    protected Double aLng() {
        return -54d;
    }

    protected Double aLat() {
        return -38d;
    }

    protected Menu aMenuThatExpiresAt(Calendar date) {
        Calendar anEarlierDate = (Calendar) date.clone();
        anEarlierDate.add(Calendar.DAY_OF_YEAR, -1);

        return new MenuBuilder().withStartDate(anEarlierDate).withExpirationDate(date).build();
    }

    protected Menu aMenuPublishedAt(Calendar aDate) {
        Calendar aLaterDate = (Calendar) aDate.clone();
        aLaterDate.add(Calendar.DAY_OF_YEAR, 1);
        return new MenuBuilder().withStartDate(aDate).withExpirationDate(aLaterDate).build();
    }

    protected Calendar anEarlierDate() {
        Calendar calendar = aDate();
        calendar.add(Calendar.YEAR, -1);
        return calendar;
    }

    protected Calendar aDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY, 4);
        return calendar;
    }

    protected Calendar aLaterDate() {
        Calendar calendar = aDate();
        calendar.add(Calendar.YEAR, 1);
        return calendar;
    }

    protected Order anOrderFor(Integer amount, Menu aMenu) {
        return aMenu.orderBy(aClient(),amount,aDeliveryType(),aTime(),aLocation());
    }

    protected Menu aMenuPricedAt(MonetaryAmount fullPrice) {
        return new MenuBuilder().withFullPrice(fullPrice).withBusiness(aBusiness()).withStartDate(aDate()).withExpirationDate(aLaterDate()).build();
    }

    protected Menu aMenuPricedAtWithBulkDiscount(MonetaryAmount fullPrice, Integer bulkSize, MonetaryAmount discountedPrice) {
        return new MenuBuilder()
                .withFullPrice(fullPrice)
                .withBusiness(aBusiness())
                .withBulkDiscount(bulkSize, discountedPrice)
                .withStartDate(aDate())
                .withExpirationDate(aLaterDate())
                .build();
    }

    protected MonetaryAmount fullPrice() {
        return Monetary.getDefaultAmountFactory().setNumber(11.1111).setCurrency("ARS").create();
    }

    protected MonetaryAmount discountedPrice() {
        return fullPrice().multiply(0.8);
    }
}
