package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.account.Account;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import org.junit.Test;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import static org.junit.Assert.assertEquals;

public class OrderTest extends EntityTest {

    @Test
    public void anOrderForASingleMenuShouldHaveFullPrice() {
        Menu aMenu = aMenuPricedAt(fullPrice());
        Order anOrder = anOrderFor(1, aMenu);

        assertEquals(
                fullPrice(),
                anOrder.getPrice()
        );
    }

    @Test
    public void aBulkOrderForAMenuShouldHaveDiscountedPrice() {
        int bulkSize = 3;
        Menu aMenu = aMenuPricedAtWithBulkDiscount(fullPrice(), bulkSize, discountedPrice());
        Order anOrder = anOrderFor(bulkSize, aMenu);

        assertEquals(
                discountedPrice().multiply(bulkSize),
                anOrder.getPrice()
        );
    }

    @Test
    public void aSimpleOrderForAMenuWithDiscountShouldNotHaveDiscountedPrice() {
        int orderAmount = 2;
        int bulkSize = 3;
        Menu aMenu = aMenuPricedAtWithBulkDiscount(fullPrice(), bulkSize, discountedPrice());
        Order anOrder = anOrderFor(orderAmount, aMenu);

        assertEquals(
                fullPrice().multiply(orderAmount),
                anOrder.getPrice()
        );
    }

    @Test
    public void allOrdersPlacedInAMenuShouldHaveDiscountOnceReachedTheBulkAmount() {
        Menu aMenu = aMenuPricedAtWithBulkDiscount(fullPrice(), 2, discountedPrice());
        Order anOrder = anOrderFor(1, aMenu);
        Order anotherOrder = anOrderFor(1, aMenu);

        assertEquals(
                discountedPrice(),
                anOrder.getPrice()
        );
        assertEquals(
                discountedPrice(),
                anotherOrder.getPrice()
        );
    }

    @Test
    public void anOrderShouldReturnAnInvoiceForTheGivenPriceWhenItIsPaid() throws AlreadyPaidException {
        Menu aMenu = aMenuPricedAt(fullPrice());
        Order anOrder = anOrderFor(1, aMenu);

        Invoice invoice = anOrder.pay();

        assertEquals(
                fullPrice(),
                invoice.getTotal()
        );
    }

    @Test
    public void allOrdersWithBulkDiscountShouldYieldAnInvoiceWithDiscountedPrice() throws AlreadyPaidException {
        Menu aMenu = aMenuPricedAtWithBulkDiscount(fullPrice(), 2, discountedPrice());
        Order anOrder = anOrderFor(1, aMenu);
        Order anotherOrder = anOrderFor(1, aMenu);

        Invoice anInvoice = anOrder.pay();
        Invoice anotherInvoice = anotherOrder.pay();

        assertEquals(
                discountedPrice(),
                anInvoice.getTotal()
        );
        assertEquals(
                discountedPrice(),
                anotherInvoice.getTotal()
        );
    }

    @Test
    public void anInvoiceWithDeliveryCostShouldHaveTheOrderPricePlusTheDeliveryPrice() throws AlreadyPaidException {
        Menu aMenu = aMenuPricedAtWithDeliveryCost(fullPrice(),aDeliveryPrice());

        Order anOrder = anOrderFor(1, aMenu);


        Invoice anInvoice = anOrder.pay();

        assertEquals(
                fullPrice().add(aDeliveryPrice()),
                anInvoice.getTotal()
        );

    }

    @Test(expected = AlreadyPaidException.class)
    public void anOrderCanNotBePayedTwice() throws AlreadyPaidException {
        Order anOrder = anOrder();
        anOrder.pay();

        anOrder.pay();
    }

    @Test
    public void anAccountShouldLessBalanceAfterPayingAnOrder() throws AlreadyPaidException {

        Account anAccount = anAccountWithBalance(aMonetaryAmount());
        Client aClient = aClientWithAccount(anAccount);
        Order anOrder = anOrderFromClient(aClient);


        Invoice invoice = anOrder.pay();


        assertEquals(
                aMonetaryAmount().subtract(invoice.getTotal()),
                anAccount.getBalance()
        );
    }




}
