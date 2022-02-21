package pl.sda.bank;

import lombok.*;
import pl.sda.bank.exceptions.BalanceToLowException;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account {


    public Account(String accountNumber, Currency currency) {
        this.accountNumber = accountNumber;
        this.currency = currency;
    }

    private String accountNumber;
    private Currency currency;
    private BigDecimal accountBalance = new BigDecimal(0);
        // poprawić warunki logiczne, wartości ujemne - wpłata, wypłata
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
