package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;
import javax.persistence.*;


@Entity
public class InvoicePaymentStatement extends Statement {

    @OneToOne(cascade = CascadeType.ALL)
    private final Invoice invoice;
    @Id
    @GeneratedValue
    private Long id;

    public InvoicePaymentStatement(Invoice invoice) {
        this.invoice = invoice;
    }

    
    public Long getId() {
        return this.id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.subtract(invoice.getTotal());
    }
}
