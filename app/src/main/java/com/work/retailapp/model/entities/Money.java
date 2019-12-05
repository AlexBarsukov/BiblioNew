package com.work.retailapp.model.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

public class Money {

    private static final Currency INR = Currency.getInstance(new Locale("ru",
            "RU"));
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

    private BigDecimal amount;
    private Currency currency;

    Money(BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING);
    }

    Money(BigDecimal amount, Currency currency, RoundingMode rounding) {
        this.amount = amount;
        this.currency = currency;

        this.amount = amount.setScale(currency.getDefaultFractionDigits(),
                rounding);
    }

    public static Money rupees(BigDecimal amount) {
        return new Money(amount, INR);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return  getAmount() + " " + getCurrency().getSymbol();
    }

    public String toString(Locale locale) {
        return getAmount() + " " + getCurrency().getSymbol(locale);
    }
}