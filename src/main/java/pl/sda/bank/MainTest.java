package pl.sda.bank;


import pl.sda.bank.exceptions.BalanceToLowException;
import pl.sda.bank.exceptions.CashIsNegativeException;
import pl.sda.bank.exceptions.ClientNotFoundExeption;
import pl.sda.bank.service.AccountService;
import pl.sda.bank.service.BankService;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class MainTest {
    /* Main testowy służący do sprawdzenia funkcjonalności napisanego kodu, który został napisany */

    public static void main(String[] args) throws ClientNotFoundExeption, BalanceToLowException, CashIsNegativeException {

        BankService bank = new BankService();


        bank.addNewClient("Jan", "Kow", new Address("Warszawa", "Długa", "55", "1", "70-150") );
        bank.addNewClient("Marian", "Kow", new Address("Warszawa", "Długa", "55", "1", "70-150") );

        //System.out.println(bank.getClientList().toString());

        /*List<Account> accountList = bank.getClientList()
                .stream()
                .flatMap(c -> {
                    return c.getAccountList().stream();
                })
                .collect(Collectors.toList());
        accountList.add(new Account("1", Currency.valueOf("PLN")));*/


        bank.getClientList().get(0).getAccountList().add(new AccountService("1", Currency.valueOf("PLN")));
        bank.getClientList().get(0).getAccountList().add(new AccountService("2", Currency.valueOf("USD")));
        bank.getClientList().get(0).getAccountList().get(0).addToAccount(BigDecimal.valueOf(1500.00));


        bank.getClientList().get(1).getAccountList().add(new AccountService("1", Currency.valueOf("PLN")));
        bank.getClientList().get(1).getAccountList().add(new AccountService("2", Currency.valueOf("USD")));
        bank.getClientList().get(1).getAccountList().add(new AccountService("2", Currency.valueOf("USD")));

        System.out.println(bank.getClientList().stream()
                .flatMap(a -> {
                    return a.getAccountList().stream();
                })
                .collect(Collectors.toList()));


        bank.removeClient(bank.getClientList().get(1));

        System.out.println("**************************");

        System.out.println(bank.getClientList().stream()
                .flatMap(a -> {
                    return a.getAccountList().stream();
                })
                .collect(Collectors.toList()));

        System.out.println("**************************");


        bank.getClientList().get(0).getAccountList().get(0).subtractFromAccount(BigDecimal.valueOf(1600.00));

        System.out.println(bank.getClientList().stream()
                .flatMap(a -> {
                    return a.getAccountList().stream();
                })
                .collect(Collectors.toList()));





        /*Client client1 = new Client("1", "Alex", "b", address, listClient1);
        Account accountAlex1 = new Account("57775757", Currency.PLN);
        Account accountAlex2 = new Account("999997", Currency.PLN);
        client1.createNewAccount(listClient1, accountAlex1);
        client1.createNewAccount(listClient1, accountAlex2);
        System.out.println(listClient1);
        client1.removeAccount(accountAlex1, listClient1);
        System.out.println(listClient1);*/


    }
}
