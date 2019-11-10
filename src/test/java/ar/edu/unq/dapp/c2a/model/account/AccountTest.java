package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.account.statement.AcreditationStatement;
import ar.edu.unq.dapp.c2a.model.account.statement.Statement;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import org.junit.Test;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

        anAccount.add(aMonetaryAmount(), "Promo regalo");

        assertEquals(
                aMonetaryAmount(),
                anAccount.getBalance()
        );
    }

    @Test
    public void anAccountShouldHaveAStatementAfterAChangeInBalance() {
        Account anAccount = aNewAccount();

        anAccount.add(aMonetaryAmount(), "promo");

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

    @Test
    public void anAccountShouldSetAndGetAndId(){
        List<Statement> movDeCuenta = new ArrayList<Statement>();
        Account anAcount = new Account(aMonetaryAmount(),movDeCuenta );
        anAcount.setStatements(movDeCuenta);
        anAcount.setId(100L);


        Long IdTest = 100L;
        Long IdCuenta = anAcount.getId();

        assertEquals(IdTest,IdCuenta);

    }

    @Test
    public void anStatementShouldSetAndGetId(){
        List<Statement> movDeCuenta = new ArrayList<Statement>();
        Statement mov = new AcreditationStatement(aMonetaryAmount(), "carga de saldo");
        mov.setId(50L);
        movDeCuenta.add(mov);
        Account anAcount = new Account(aMonetaryAmount(),movDeCuenta );
        anAcount.setStatements(movDeCuenta);


        Long IdTest = 50L;
        Long IdMov = mov.getId();

        assertEquals(IdTest,IdMov);

    }
}
