package pl.sda.bank;

import lombok.*;
import pl.sda.bank.exceptions.AccountNotFoundException;
import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.CashIsNegativeException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private List<Account> accountList = new ArrayList<>();

    public Client(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


    public void createNewAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        account.setAccountNumber(scanner.nextLine());
        account.setCurrency(Currency.valueOf(scanner.nextLine()));
        account.setAccountNumber(scanner.nextLine());
        accountList.add(account);
    }

    public void createNewAccount(String accountNumber, Currency currency) {
        accountList.add(new Account(accountNumber,currency));
    }

    public List<Account> removeAccount(Account account) throws AccountNotFoundException {
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
        if (cash.compareTo(new BigDecimal(0)) >= 0) { //>= accountBalance?
            account.subtractFromAccount(cash);
        } else {
            throw new CashIsNegativeException();
        }

    }

}
