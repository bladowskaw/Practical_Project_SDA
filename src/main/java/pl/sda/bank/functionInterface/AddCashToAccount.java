package pl.sda.bank.functionInterface;

import pl.sda.bank.exceptions.CashIsNegativeException;

import java.math.BigDecimal;

@FunctionalInterface
public interface AddCashToAccount {
    void addToAccount(BigDecimal cash) throws CashIsNegativeException;
}


