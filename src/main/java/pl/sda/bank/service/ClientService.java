package pl.sda.bank.service;

import lombok.*;
import pl.sda.bank.Address;
import pl.sda.bank.Currency;
import pl.sda.bank.exceptions.AccountNotFoundException;
import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.CashIsNegativeException;
import pl.sda.bank.model.ClientModel;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClientService extends ClientModel {

    public ClientService(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public void createNewAccount(String accountNumber, Currency currency) {
        accountList.add(new AccountService(accountNumber,currency));
    }

    public List<AccountService> removeAccount(AccountService account) throws AccountNotFoundException {
        if (accountList.contains(account)) {
            accountList.remove(account);
        } else {
            throw new AccountNotFoundException();
        }
        return this.accountList;
    }

    public static void depositCash(AccountService account, BigDecimal cash) throws CashIsNegativeException {
        if (cash.compareTo(new BigDecimal(0)) > 0) {
            account.addToAccount(cash);
        } else {
            throw new CashIsNegativeException();
        }
    }

    public static void withdrawCash(AccountService account, BigDecimal cash) throws BalanceToLowException, CashIsNegativeException {
        if (cash.compareTo(new BigDecimal(0)) >= 0) { //>= accountBalance?
            account.subtractFromAccount(cash);
        } else {
            throw new CashIsNegativeException();
        }

    }

}