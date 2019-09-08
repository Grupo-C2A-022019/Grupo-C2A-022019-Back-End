package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;

public class InvoicePaymentStatement extends EntityImp implements Statement {
    private final Invoice invoice;

    public InvoicePaymentStatement(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.subtract(invoice.getTotal());
    }
}
