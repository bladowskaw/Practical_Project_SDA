package pl.sda.bank;

import lombok.*;
import pl.sda.bank.exceptions.AccountNotFoundException;
import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.CashIsNegativeException;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Client {

    private String clientId;
    private String firstName;
    private String lastName;
    private Address address;
    private List<Account> accountList;

    public Client(String clientId, String firstName, String lastName, Address address, List<Account> accountList) {
    }

    public List<Account> createNewAccount(List<Account> accountList, Account account) {
        accountList.add(account);
        return accountList;
    }

    public List<Account> removeAccount(Account account, List<Account> accountList) throws AccountNotFoundException {
        if (accountList.contains(account)) {
            accountList.remove(account);
        } else {
            throw new AccountNotFoundException();
        }
        return this.accountList;
    }

    public static void depositCash(Account account, BigDecimal cash) throws CashIsNegativeException {
        if (cash.compareTo(new BigDecimal(0)) > 0) {
            account.addToAccount(cash);
        } else {
            throw new CashIsNegativeException();
        }
    }

    public static void withdrawCash(Account account, BigDecimal cash) throws BalanceToLowException, CashIsNegativeException {
        if (cash.compareTo(new BigDecimal(0)) >= 0) {
            account.subtractFromAccount(cash);
        } else {
            throw new CashIsNegativeException();
        }

    }

}
