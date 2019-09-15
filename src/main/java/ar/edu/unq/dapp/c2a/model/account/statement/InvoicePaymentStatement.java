package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;
import javax.persistence.*;


@Entity
public class InvoicePaymentStatement implements Statement {

    @OneToOne
    private final Invoice invoice;
    @Id
    @GeneratedValue
    private Long id;

    public InvoicePaymentStatement(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.subtract(invoice.getTotal());
    }
}
