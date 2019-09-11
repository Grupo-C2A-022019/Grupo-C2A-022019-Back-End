package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import org.junit.Test;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import static org.junit.Assert.assertEquals;

public class AccountTest extends EntityTest {

    @Test
    public void aNewAccountShouldHaveBalanceZero() {
        assertEquals(
                Monetary.getDefaultAmountFactory().setNumber(0).setCurrency("ARS").create(),
                aNewAccount().getBalance()
        );
    }

    @Test
    public void anAccountShouldHaveNonZeroBalanceAfterAddingMoney() {
        Account anAccount = aNewAccount();

        anAccount.add(aMonetaryAmount());

        assertEquals(
                aMonetaryAmount(),
                anAccount.getBalance()
        );
    }

    @Test
    public void anAccountShouldHaveAStatementAfterAChangeInBalance() {
        Account anAccount = aNewAccount();

        anAccount.add(aMonetaryAmount());

        assertEquals(
                1,
                anAccount.getStatements().size()
        );
    }

    @Test
    public void anAccountShouldHaveLessBalanceAfterPayingAnInvoice() {
        MonetaryAmount cost = aMonetaryAmount();
        MonetaryAmount balance = aMonetaryAmount();
        Invoice invoice = anInvoiceWithTotal(cost);
        Account anAccount = anAccountWithBalance(balance);

        anAccount.pay(invoice);

        assertEquals(
                balance.subtract(cost),
                anAccount.getBalance()
        );
        assertEquals(
                1,
                anAccount.getStatements().size()
        );
    }


}
