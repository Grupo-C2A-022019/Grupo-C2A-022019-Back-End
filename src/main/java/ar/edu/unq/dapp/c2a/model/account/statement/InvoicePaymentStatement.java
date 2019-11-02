package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class InvoicePaymentStatement extends Statement {

    @OneToOne(cascade = CascadeType.ALL)
    private Invoice invoice;

    public InvoicePaymentStatement() {
    }

    public InvoicePaymentStatement(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Transient
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.subtract(invoice.getTotal());
    }
}
