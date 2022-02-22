package pl.sda.bank;

import lombok.*;
import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.CashIsNegativeException;
import pl.sda.bank.functionInterface.AddCashToAccount;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account implements AddCashToAccount {


    public Account(String accountNumber, Currency currency) {
        this.accountNumber = accountNumber;
        this.currency = currency;
    }

    private String accountNumber;
    private Currency currency;
    private BigDecimal accountBalance = new BigDecimal(0);

    public void addToAccount(BigDecimal cash) throws CashIsNegativeException {
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
