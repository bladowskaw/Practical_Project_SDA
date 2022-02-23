package pl.sda.bank.service;

import org.jetbrains.annotations.NotNull;
import pl.sda.bank.Currency;
import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.CashIsNegativeException;
import pl.sda.bank.model.Account;

import java.math.BigDecimal;

public class AccountService extends Account {

    public AccountService(String accountNumber, Currency currency) {
        super.accountNumber = accountNumber;
        super.currency = currency;
    }

    public void addToAccount(@NotNull BigDecimal cash) throws CashIsNegativeException {
        if (cash.compareTo(BigDecimal.ZERO) > 0) {
            accountBalance = accountBalance.add(cash);
        } else {
            throw new CashIsNegativeException();
        }
    }

    public void subtractFromAccount(BigDecimal cash) throws BalanceToLowException, CashIsNegativeException {
        if (accountBalance.compareTo(cash) < 0) {
            throw new BalanceToLowException();
        } else if (cash.compareTo(BigDecimal.ZERO) < 0) {
            throw new CashIsNegativeException();
        }
        accountBalance = accountBalance.subtract(cash);
    }
}
