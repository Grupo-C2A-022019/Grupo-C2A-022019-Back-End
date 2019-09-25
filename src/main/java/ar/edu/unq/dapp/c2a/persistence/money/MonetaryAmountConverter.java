package ar.edu.unq.dapp.c2a.persistence.money;


import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

    static String SEPARATOR = "-";

    @Override
    public String convertToDatabaseColumn(MonetaryAmount monetaryAmount) {
        return monetaryAmount.getNumber().doubleValueExact() +
                SEPARATOR +
                monetaryAmount.getCurrency();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String monetaryAmount) {
        String[] split = monetaryAmount.split(SEPARATOR);
        return Monetary
                .getDefaultAmountFactory()
                .setNumber(Double.valueOf(split[0]))
                .setCurrency(split[1])
                .create();
    }
}