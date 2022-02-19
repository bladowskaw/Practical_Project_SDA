package pl.sda.bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.sda.bank.exceptions.BalanceToLowException;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class Account {

    private final String accountNumber;
    private final Currency currency;
    private BigDecimal accountBalance = new BigDecimal(0);

    public void addToAccount(BigDecimal cash) {
        accountBalance = accountBalance.add(cash);
    }

    public void subtractFromAccount(BigDecimal cash) throws BalanceToLowException {
        if (cash.compareTo(accountBalance) > 0){
            throw new BalanceToLowException();
        }
        accountBalance = accountBalance.subtract(cash);
        //porównaj czy kasa <= stan konta

    }

}
