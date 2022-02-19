package pl.sda.bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.CashIsNegativeException;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Account {

    private final String accountNumber;
    private final Currency currency;
    private BigDecimal accountBalance = new BigDecimal(0);

    public void addToAccount(BigDecimal cash) {
        accountBalance = accountBalance.add(cash);
    }

    public void subtractFromAccount(BigDecimal cash) throws BalanceToLowException {
        if (cash.compareTo(accountBalance) > 0) {
            throw new BalanceToLowException();
        }
        accountBalance = accountBalance.subtract(cash);
        //porównaj czy kasa <= stan konta

    }

}
