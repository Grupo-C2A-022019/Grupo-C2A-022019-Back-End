package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.*;


@Entity
public class AcreditationStatement extends Statement {

    @Convert(converter = MonetaryAmountConverter.class)
    private final MonetaryAmount monetaryAmount;
    @Id
    @GeneratedValue
    private Long id;

    public AcreditationStatement(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

    
    public Long getId() {
        return this.id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.add(monetaryAmount);
    }
}
